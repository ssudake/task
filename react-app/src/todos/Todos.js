import {useState, useEffect} from "react";
import styles from "./Todos.module.css";

/*const initialState = [
  { id: 1, text: "Buy Milk", status: "pending", priority: 1 },
  { id: 2, text: "Attend meeting", status: "pending", priority: 2 },
];*/

export const Todos = (props) => {
    const [todos, setTodos] = useState([]);
    const [todoText, setTodoText] = useState("");

    useEffect(() => {
        fetch("/todos")
            .then((r) => r.json())
            .then(data => setTodos(data))
            .catch((e) => alert(`Oops error occured: ${e.message}`));
    }, []);


    const updateTodoAPI = (todo) => {
        fetch(`/todos/update/${todo.id}`, {method: "PUT", body: JSON.stringify(todo)})
            .catch((e) => alert(`Oops error occured: ${e.message}`));
    }

    const addTodoAPI = (userId) => {
        var headers = new Headers();
        headers.append("Content-Type", "application/json;charset=UTF-8;");
        var requestOptions = {
            method: 'POST',
            headers: headers,
            body: {text: todoText},
            redirect: 'follow'
        };

        alert(JSON.stringify(todoText))
        fetch(`/todos/add/${userId}`, requestOptions)
            .then((r) => r.json())
            .catch((e) => alert(`Oops error occured: ${e.message}`));
    }

    const deleteTodoAPI = (todo) => {
        fetch(`/todos/delete/${todo.id}`, {method: "DELETE", body: JSON.stringify(todo)})
            .then((r) => r.json())
            .catch((e) => alert(`Oops error occured: ${e.message}`));
    }

    const getTodoByIdAPI = (todo) => {
        fetch(`/todos/${todo.id}`, {method: "GET", body: JSON.stringify(todo),})
            .then((r) => r.json())
            .catch((e) => alert(`Oops error occured: ${e.message}`));
    }

    const toggleTodo = (id) => {
        const updatedTodos = todos.map((t) => {
            if (t.id === id) {
                t.status = t.status === "pending" ? "completed" : "pending";
            }

            return t;
        });

        setTodos(updatedTodos);
    };


    return (
        <div className={styles.container}>
            <div>
                <input type="text" value={todoText} onChange={(e) => {
                    setTodoText(e.target.value);
                }}/>
                <button onClick={() => addTodoAPI(123)}>ADD TODO</button>
            </div>
            <ul className={styles.list}>
                {todos.map((t) => (
                    <li
                        className={
                            t.status === "pending" ? styles.pending : styles.completed
                        }
                        key={t.id}
                        onClick={() => toggleTodo(t.id)}>
                        <input type="checkbox" checked={t.status === "completed"}></input>
                        {t.text}
                    </li>
                ))}
            </ul>
        </div>
    );
};
