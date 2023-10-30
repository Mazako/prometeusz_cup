import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import {getAllTeamRequest} from "../../endpoints/endpoints";

const initialState = {
    currentTeam: {

    },
    teams: {

    }
}

export const getAllTeams = createAsyncThunk('teams/getAllTeams', async (arg) => {
    return await getAllTeamRequest();
})

const teamsSlice = createSlice({
    name: 'teams',
    initialState: initialState,
    reducers: {
        setCurrentTeam: (state, action) => {
            state.currentTeam = action.payload
        }
    },
    extraReducers: {
        [getAllTeams.fulfilled]: (state, action) => {
            action.payload.map(team => state.teams[team.id] = team)
        }
    }
})

export const allTeams = state => state.teams.teams
export const currentTeam = state => state.teams.currentTeam

export const {setCurrentTeam} = teamsSlice.actions

export const teamsReducer = teamsSlice.reducer