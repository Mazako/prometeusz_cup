import {useParams} from "react-router";
import {useEffect, useState} from "react";
import {getTeamDetailsRequest} from "../../endpoints/endpoints";

export function SingleTeamCard() {
    const params = useParams()
    const [teamDetails, setTeamDetails] = useState({})

    useEffect(() => {
        const getTeamDetails = async () => {
            try {
                let details = await getTeamDetailsRequest(params['id'])
                setTeamDetails(details)
            } catch (e) {
                alert('chujnia')
            }
        }

        getTeamDetails()
    }, [setTeamDetails]);

    return (
        <div>
            <h2>{teamDetails.team.name}</h2>
        </div>
    )

}