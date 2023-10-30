import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import {login} from "../../endpoints/endpoints";

const initialState = {
    logged: false,
    loginFailed: false,
    token: null
}

export const loginUser = createAsyncThunk("login/loginUser", async (arg) => {
    console.log(arg)
    const token = await login(arg)
    localStorage.setItem("login-token", token)
})

const loginSlice = createSlice({
    name: 'login',
    initialState: initialState,
    reducers: {
        setToken: (state, action) => {
            state.token = action.payload
            state.loginFailed = false
            state.logged = true
        },

        clearLoginFailed:  state => {
            state.loginFailed = false
        }
    },
    extraReducers: {
        [loginUser.fulfilled]: (state, action) => {
            state.logged = true
            state.loginFailed = false
            state.token = action.payload
        },

        [loginUser.rejected]: (state, action) => {
            console.log('XD')
            state.loginFailed = true
            state.logged = false
        }
    }
})
export const isLoginFailed = state => state.login.loginFailed

export const isLoggedIn = state => state.login.logged
export const {setToken, clearLoginFailed} = loginSlice.actions
export const loginReducer = loginSlice.reducer;
