package pl.mazak.backend.startup;

import org.apache.hc.client5.http.HttpResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.mazak.backend.lolapi.LeagueOfLegendsApiClient;
import pl.mazak.backend.lolapi.RankInfoDTO;
import pl.mazak.backend.lolapi.SummonerDTO;
import pl.mazak.backend.persistance.Participant;
import pl.mazak.backend.persistance.ParticipantRepository;
import pl.mazak.backend.persistance.Team;

import java.io.IOException;
import java.io.UncheckedIOException;


public class StartupWorker {
    private static final Logger logger = LoggerFactory.getLogger(StartupWorker.class);
    private final ParticipantRepository participantRepository;
    private final LeagueOfLegendsApiClient lolApiClient;
    private final boolean runUserFetch;

    public StartupWorker(ParticipantRepository participantRepository,
                         LeagueOfLegendsApiClient leagueOfLegendsApiClient,
                         boolean runUserFetch) {
        this.participantRepository = participantRepository;
        this.lolApiClient = leagueOfLegendsApiClient;
        this.runUserFetch = runUserFetch;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void runOnStart() {
        if (runUserFetch) {
            addParticipantsToDatabase();
        }
    }

    public void addParticipantsToDatabase() {
        logger.info("ADDING ALL USERS TO DB");
        NewUserDTO.getTournamentUsers().forEach(user -> {
            try {
                fetchAndPersistParticipants(user);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }

    private void fetchAndPersistParticipants(NewUserDTO user) throws IOException {
        logger.info("Getting info of {}", user.summonerName());
        try {
            SummonerDTO summoner = lolApiClient.getSummonerInfoByName(user.summonerName());
            RankInfoDTO summonerRanks = lolApiClient.getSummonerRanks(summoner.id(), summoner.name());
            participantRepository.save(new Participant(summoner.id(),
                    summoner.puuid(),
                    summoner.name(),
                    user.captain(),
                    summonerRanks.soloQTier(),
                    summonerRanks.soloQRank(),
                    summonerRanks.flexRank(),
                    summonerRanks.flexTier(),
                    new Team(user.teamId()),
                    summoner.profileIconId(),
                    user.role()));

        } catch (HttpResponseException e) {
            logger.info("Failed to fetch data of {} - error code: {}", user.summonerName(), e.getStatusCode());
        }
    }


}
