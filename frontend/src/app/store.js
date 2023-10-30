import {configureStore} from "@reduxjs/toolkit";
import {loginReducer} from "../features/login/loginSlice";
import {teamsReducer} from "../features/teams/teamsSlice";

export const store = configureStore({
    reducer: {
        login: loginReducer,
        teams: teamsReducer,
    }
})