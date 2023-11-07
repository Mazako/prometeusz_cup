import {useParams} from "react-router";
import {useEffect, useState} from "react";
import {getTeamDetailsRequest} from "../../endpoints/endpoints";
import {ParticipantEntry} from "./ParticipantEntry";

export function SingleTeamCard() {
    const params = useParams()
    const [teamDetails, setTeamDetails] = useState({})
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        const getTeamDetails = async () => {
            setLoading(true)
            try {
                let details = await getTeamDetailsRequest(params['id'])
                setTeamDetails(details)
                setLoading(false)
            } catch (e) {
                alert('chujnia')
            }
        }

        getTeamDetails()
    }, []);

    if (loading) {
        return <p>Loading...</p>
    }
    return (
        <div>
            <h2>{teamDetails.team.name}</h2>
            <ul>
                {
                    teamDetails.participantDTOs
                        .map(participant => <ParticipantEntry key={participant.name.hash}
                                                              name={participant.name}
                                                              iconId={participant.iconId}
                                                              captain={participant.captain}
                                                              soloqTier={participant.soloqTier}
                                                              soloqRank={participant.soloqRank}
                                                              flexTier={participant.flexTier}
                                                              flexRank={participant.flexRank}
                                                              role={participant.role}/> )
                }
            </ul>
        </div>
    )

}