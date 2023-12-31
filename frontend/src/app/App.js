import {createRoutesFromElements, Route, RouterProvider, Routes} from "react-router";
import {createBrowserRouter} from "react-router-dom";
import {LoginPage} from "../components/login_page/LoginPage";
import {MainPage} from "../components/MainPage";
import {useEffect} from "react";
import {useDispatch} from "react-redux";
import {setToken} from "../features/login/loginSlice";
import {AllTeamsList} from "../components/teams/AllTeamsList";
import {SingleTeamCard} from "../components/teams/SingleTeamCard";

function App() {
    const dispatch = useDispatch()
    useEffect(() => {
        const localStorageToken = localStorage.getItem('login-token')
        if (localStorageToken) {
            dispatch(setToken(localStorageToken))
        }
    }, [dispatch]);

    const router = createBrowserRouter(createRoutesFromElements([
            <Route path={"/"} element={<MainPage />}>
                <Route path='/allTeams' element={<AllTeamsList />} />
                <Route path='/team/:id' element={<SingleTeamCard />} />
            </Route>,
            <Route path="/zodyn-kurwa-nie-ogarnie" element={<LoginPage />} />
]))
    return (
        <RouterProvider router={router}/>
    );
}

export default App;
