package pl.mazak.backend.lolapi;

public record SummonerDTO(String accountId,
                   int profileIconId,
                   long revisionDate,
                   String name,
                   String id,
                   String puuid,
                   String summonerLevel) {

}
