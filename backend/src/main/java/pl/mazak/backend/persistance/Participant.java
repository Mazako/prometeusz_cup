package pl.mazak.backend.persistance;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @Size(max = 120)
    @Column(name = "summoner_id", nullable = false, length = 120)
    private String summonerId;

    @Size(max = 120)
    @NotNull
    @Column(name = "puuid", nullable = false, length = 120)
    private String puuid;

    @Size(max = 60)
    @NotNull
    @Column(name = "summoner_name", nullable = false, length = 60)
    private String summonerName;

    @Column(name = "captain")
    private Boolean captain;

    @Size(max = 10)
    @Column(name = "soloq_tier", length = 10)
    private String soloqTier;

    @Size(max = 3)
    @Column(name = "soloq_rank", length = 3)
    private String soloqRank;

    @Size(max = 3)
    @Column(name = "flex_rank", length = 3)
    private String flexRank;

    @Size(max = 10)
    @Column(name = "flex_tier", length = 10)
    private String flexTier;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_role")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    @NotNull
    @Column(name = "avatar_id", nullable = false)
    private Integer avatarId;

    public Participant(String summonerId,
                       String puuid,
                       String summonerName,
                       Boolean captain,
                       String soloqTier,
                       String soloqRank,
                       String flexRank,
                       String flexTier,
                       Team team,
                       Integer avatarId,
                       Role role) {
        this.summonerId = summonerId;
        this.puuid = puuid;
        this.summonerName = summonerName;
        this.captain = captain;
        this.soloqTier = soloqTier;
        this.soloqRank = soloqRank;
        this.flexRank = flexRank;
        this.flexTier = flexTier;
        this.team = team;
        this.avatarId = avatarId;
        this.role = role;
    }

    public Participant() {

    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public String getSoloqTier() {
        return soloqTier;
    }

    public void setSoloqTier(String soloqTier) {
        this.soloqTier = soloqTier;
    }

    public String getSoloqRank() {
        return soloqRank;
    }

    public void setSoloqRank(String soloqRank) {
        this.soloqRank = soloqRank;
    }

    public String getFlexRank() {
        return flexRank;
    }

    public void setFlexRank(String flexRank) {
        this.flexRank = flexRank;
    }

    public String getFlexTier() {
        return flexTier;
    }

    public void setFlexTier(String flexTier) {
        this.flexTier = flexTier;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}