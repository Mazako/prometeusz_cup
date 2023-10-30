import {NavLink} from "react-router-dom";
import styles from './NavBar.module.css'
import {useSelector} from "react-redux";
import {isLoggedIn} from "../../features/login/loginSlice";

export function NavBar() {
    const loggedIn = useSelector(isLoggedIn)
    return (
        <div className={styles.mainNavBar}>
            <h1>Prometeusz.app</h1>
            {loggedIn && <p className={styles.loggedIn}>ZALOGOWANO</p>}
            <ul className={styles.elementsList}>
                <li><NavLink to='/'>Drabinka</NavLink></li>
                <li><NavLink to='/'>Lista zespolow</NavLink></li>
                <li><NavLink to='/'>Zawodnicy</NavLink></li>
            </ul>
        </div>
    )
}