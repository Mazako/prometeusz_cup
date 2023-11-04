package pl.mazak.backend.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("""
            SELECT new pl.mazak.backend.persistance.TeamWithCaptain(t.id, t.name, p.summonerName, p.avatarId)
            FROM Team t
            JOIN Participant p ON p.team.id = t.id
            WHERE p.captain = true
            """)
    List<TeamWithCaptain> getAllTeamsAndCaptains();
}
