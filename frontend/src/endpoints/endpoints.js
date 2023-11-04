export const login = async (payload) => {
    const response = await fetch(`http://localhost:8080/login`, {
        method: 'POST',
        body: JSON.stringify(payload),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    const json = await response.json()
    return json['token'];
}

export const getAllTeamRequest = async () => {
    const response = await fetch('http://localhost:8080/publicApi/team/allTeams');
    return await response.json()
}

export const getTeamDetailsRequest = async (id) => {
    const response = await fetch(`http://localhost:8080/publicApi/participant/byTeam?teamId=${id}`)
    return await response.json()
}

export const getImageIcon = (id) => {
    return `http://ddragon.leagueoflegends.com/cdn/13.21.1/img/profileicon/${id}.png`
}