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
    const response = await fetch('http://localhost:8080/publicApi/allTeams');
    return await response.json()
}