import {NavBar} from "./nav_bar/NavBar";
import {Outlet} from "react-router";

export function MainPage() {
    return (
        <div>
            <NavBar />
            <div>
                Hello
            </div>
            <Outlet />
        </div>
    )
}