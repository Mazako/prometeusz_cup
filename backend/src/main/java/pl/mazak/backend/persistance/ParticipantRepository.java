package pl.mazak.backend.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, String> {

    @Query("SELECT p FROM Participant p JOIN Team t ON p.team.id = t.id WHERE p.team.id = :teamId")
    List<Participant> getParticipantsByTeam(Long teamId);

    @Query("SELECT p FROM Participant p JOIN Team t ON p.team.id = t.id WHERE p.team.id = :teamId AND p.captain = true")
    Participant getCaptainOfTeam(Long teamId);
}
