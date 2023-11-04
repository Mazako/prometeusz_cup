package pl.mazak.backend.startup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mazak.backend.lolapi.LeagueOfLegendsApiClient;
import pl.mazak.backend.persistance.ParticipantRepository;
import pl.mazak.backend.persistance.TeamRepository;

@Configuration
public class StartupConfig {

    @Value("${startup.run-user-fetch:false}")
    private boolean runUserFetch;

    @Bean
    StartupWorker startupWorker(ParticipantRepository participantRepository,
                                LeagueOfLegendsApiClient leagueOfLegendsApiClient) {
        return new StartupWorker(participantRepository, leagueOfLegendsApiClient, runUserFetch);
    }

}
