package pl.mazak.backend.participant;

import org.springframework.stereotype.Service;
import pl.mazak.backend.persistance.Participant;
import pl.mazak.backend.persistance.ParticipantRepository;
import pl.mazak.backend.persistance.Role;
import pl.mazak.backend.persistance.TeamRepository;
import pl.mazak.backend.team.TeamService.TeamDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final TeamRepository teamRepository;

    public ParticipantService(ParticipantRepository participantRepository, TeamRepository teamRepository) {
        this.participantRepository = participantRepository;
        this.teamRepository = teamRepository;
    }

    public Optional<AllParticipantsDTO> getParticipantsByTeam(Long teamId) {
        List<ParticipantDTO> list = participantRepository.getParticipantsByTeam(teamId)
                .stream()
                .map(ParticipantDTO::fromParticipant)
                .toList();

        Optional<TeamDTO> team = teamRepository.findById(teamId).map(TeamDTO::fromTeam);
        return team.map(value -> new AllParticipantsDTO(team.get(), list));
    }


    public record AllParticipantsDTO(TeamDTO team, List<ParticipantDTO> participantDTOs) {

    }
    public record ParticipantDTO(String name,
                                 Boolean captain,
                                 String soloqTier,
                                 String soloqRank,
                                 String flexRank,
                                 String flexTier,
                                 Role role){
        static ParticipantDTO fromParticipant(Participant participant) {
            return new ParticipantDTO(participant.getSummonerName(),
                    participant.getCaptain(),
                    participant.getSoloqTier(),
                    participant.getSoloqRank(),
                    participant.getFlexRank(),
                    participant.getFlexTier(),
                    participant.getRole());
        }
    }
}
