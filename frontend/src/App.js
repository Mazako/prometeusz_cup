import {useState} from "react";
import {UserPlaceholder} from "./UserPlaceholder";

function App() {
    const [count, setCount] = useState(0)

    return (
        <div>
            <UserPlaceholder name={"mazak"}/>
            <p>Clicks: {count}</p>
            <button onClick={() => setCount(prevState => prevState - 1)}>-</button>
            <button onClick={() => setCount(prevState => prevState + 1)}>+</button>
        </div>
    );
}

export default App;
