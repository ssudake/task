import "./App.css";
import { UserPorfile } from "./profile/UserProfile";
import { Todos } from "./todos/Todos";

function App(props) {
  return (
    <div className="App">
      <Todos />
      <UserPorfile />
    </div>
  );
}

export default App;
