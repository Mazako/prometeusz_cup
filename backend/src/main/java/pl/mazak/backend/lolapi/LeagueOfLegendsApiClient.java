package pl.mazak.backend.lolapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public class LeagueOfLegendsApiClient {
    private final String lolApiKey;
    private final ObjectMapper objectMapper;
    private final CloseableHttpClient httpClient;
    LeagueOfLegendsApiClient(String lolApiKey) {
        this.lolApiKey = lolApiKey;
        this.objectMapper = new ObjectMapper()
                .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.httpClient = HttpClients.createDefault();
    }


    public SummonerDTO getSummonerInfoByName(String summonerName) throws IOException {
        var getSummonerInfo = getRequest(String.format("https://eun1.api.riotgames.com/lol/summoner/v4/summoners/by-name/%s",
                URLEncoder.encode(summonerName, StandardCharsets.UTF_8)));

        String response = httpClient.execute(getSummonerInfo, new BasicHttpClientResponseHandler());

        return objectMapper.readValue(response, SummonerDTO.class);
    }

    public RankInfoDTO getSummonerRanks(String summonerId, String summonerName) throws IOException {
        HttpGet getRankInfo = getRequest(String.format("https://eun1.api.riotgames.com/lol/league/v4/entries/by-summoner/%s",
                URLEncoder.encode(summonerId, StandardCharsets.UTF_8)));

        String rankResponse = httpClient.execute(getRankInfo, new BasicHttpClientResponseHandler());

        LeagueEntryDTO[] rankedInfo = objectMapper.readValue(rankResponse, LeagueEntryDTO[].class);
        AtomicReference<Optional<LeagueEntryDTO>> soloQ = new AtomicReference<>(Optional.empty());
        AtomicReference<Optional<LeagueEntryDTO>> flex = new AtomicReference<>(Optional.empty());

        Arrays.stream(rankedInfo)
                .forEach(dto -> {
                    if (dto.queueType().equals("RANKED_SOLO_5x5")) {
                        soloQ.set(Optional.of(dto));
                    } else {
                        flex.set(Optional.of(dto));
                    }
                });

        return new RankInfoDTO(summonerName,
                soloQ.get().map(LeagueEntryDTO::tier).orElse(null),
                soloQ.get().map(LeagueEntryDTO::rank).orElse(null),
                flex.get().map(LeagueEntryDTO::tier).orElse(null),
                flex.get().map(LeagueEntryDTO::rank).orElse(null));
    }

    private HttpGet getRequest(String uri) {
        HttpGet get = new HttpGet(uri);
        get.addHeader("X-Riot-Token", lolApiKey);
        return get;
    }

}
