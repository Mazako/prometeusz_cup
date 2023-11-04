package pl.mazak.backend.lolapi;

public record RankInfoDTO(String summonerName,
                          String soloQTier,
                          String soloQRank,
                          String flexTier,
                          String flexRank) {
}
