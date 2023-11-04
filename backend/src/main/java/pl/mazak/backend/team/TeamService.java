package pl.mazak.backend.team;

import org.springframework.stereotype.Service;
import pl.mazak.backend.persistance.Team;
import pl.mazak.backend.persistance.TeamRepository;
import pl.mazak.backend.persistance.TeamWithCaptain;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamWithCaptain> getAllTeams() {
        return teamRepository.getAllTeamsAndCaptains();
    }

    public record TeamDTO(Long id, String name) {
        public static TeamDTO fromTeam(Team team) {
            return new TeamDTO(team.getId(), team.getName());
        }
    }

    public record TeamWithCaptainDTO(Long id, String name, String captainName, String captainAvatarId) { }

}
