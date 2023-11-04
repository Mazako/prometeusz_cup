package pl.mazak.backend.lolapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeagueOfLegendsApiConfig {

    @Value("${lol-api.key}")
    private String apiKey;


    @Bean
    LeagueOfLegendsApiClient leagueOfLegendsApiService() {
        return new LeagueOfLegendsApiClient(apiKey);
    }
}
