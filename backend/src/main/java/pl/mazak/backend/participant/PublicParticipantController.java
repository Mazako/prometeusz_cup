package pl.mazak.backend.participant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mazak.backend.participant.ParticipantService.AllParticipantsDTO;

@RestController
@RequestMapping("/publicApi/participant")
public class PublicParticipantController {

    private final ParticipantService participantService;

    public PublicParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/byTeam")
    public ResponseEntity<AllParticipantsDTO> getParticipantsByTeam(@RequestParam Long teamId) {
        return participantService.getParticipantsByTeam(teamId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
