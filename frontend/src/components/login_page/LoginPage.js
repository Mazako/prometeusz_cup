import {useEffect, useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {clearLoginFailed, isLoggedIn, isLoginFailed, loginUser} from "../../features/login/loginSlice";
import {useNavigate} from "react-router";
import styles from './loginPage.module.css'

export function LoginPage() {
    const [login, setLogin] = useState('')
    const [password, setPassword] = useState('')
    const dispatch = useDispatch()
    const isFailed = useSelector(isLoginFailed)
    const isLogged = useSelector(isLoggedIn)
    const navigator = useNavigate()
    const handleSubmitLogin = (e) => {
        e.preventDefault()
        dispatch(loginUser({
            username: login,
            password: password
        }))
    }

    useEffect(() => {
        if (isLogged) {
            navigator('/')
        }
    }, [isLogged, navigator])

    useEffect(() => {
        dispatch(clearLoginFailed())
    }, [dispatch]);

    return (
        <div className={styles.essa}>
        <form onSubmit={handleSubmitLogin} className={styles.myForm}>
            <label htmlFor="login">Login </label>
            <input type="text"
                   id="login"
                   onChange={(e) => setLogin(e.target.value)}
                   disabled={isLogged}/>
            <label htmlFor="password">Password </label>
            <input type="password"
                   id="password"
                   onChange={(e) => setPassword(e.target.value)}
                   disabled={isLogged}/>
            {!isFailed || <p>Login failed</p>}
            {isLogged && <p>Pomyslnie zalogowano</p>}

            <button type="submit" className={styles.loginButon} disabled={isLogged}>LOG IN</button>
        </form>

        </div>
    )
}