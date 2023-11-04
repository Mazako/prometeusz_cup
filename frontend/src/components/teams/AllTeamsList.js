import {useEffect, useState} from "react";
import {getAllTeamRequest, getImageIcon} from "../../endpoints/endpoints";
import styles from './AllTeamsList.module.css'

export function AllTeamsList() {
    const [teams, setTeams] = useState([])
    const [teamsLoading, setTeamsLoading] = useState(true)
    const [failed, setFailed] = useState(false);
    const setAllTeams = async () => {
        setTeamsLoading(true)
        try {
            setTeams(await getAllTeamRequest())
            setFailed(false)
        } catch (e) {
            setFailed(true)
        } finally {
            setTeamsLoading(false)
        }
    }

    useEffect(() => {
        setAllTeams()
    }, []);

    if (teamsLoading) {
        return <p>Loading...</p>
    }

    if (failed) {
        return (<>
                <p>Nie udało się pobrać listy zawodników. Kliknij aby spróbować jeszcze raz</p>
                <button onClick={setAllTeams}>KLIK</button>
            </>
        )
    }

    return (
        <div>
            <ul className={styles.teamsList}>
                {teams.map((team) => (
                    <li key={team.id}
                        className={styles.teamListItem}>
                        <h2>{team.name}</h2>
                        <p className={styles.captain}>Kapitan</p>
                        <img src={getImageIcon(team.captainAvatarId)} className={styles.image}/>
                        <p>{team.captainName}</p>
                    </li>
                ))}
            </ul>
        </div>
    )
}