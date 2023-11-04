package pl.mazak.backend.team;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mazak.backend.persistance.TeamWithCaptain;

import java.util.List;

@RestController
@RequestMapping("/publicApi/team")
public class PublicTeamController {

    private final TeamService teamService;

    public PublicTeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/allTeams")
    public ResponseEntity<List<TeamWithCaptain>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

}
