package pl.mazak.backend.lolapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LeagueEntryDTO(@JsonProperty("summonerName") String summonerName,
                      @JsonProperty("queueType") String queueType,
                      @JsonProperty("tier") String tier,
                      @JsonProperty("rank") String rank){
}
