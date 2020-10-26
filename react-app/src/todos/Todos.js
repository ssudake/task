import { useState, useEffect } from "react";
import styles from "./Todos.module.css";

const initialState = [
  { id: 1, text: "Buy Milk", status: "pending", priority: 1 },
  { id: 2, text: "Attend meeting", status: "pending", priority: 2 },
];

export const Todos = (props) => {
  const [todos, setTodos] = useState(initialState);

  //   useEffect(() => {
  //     fetch("/todos")
  //       .then((r) => r.json())
  //       .then(setTodos(todos))
  //       .catch((e) => alert(`Oops error occured: ${e.message}`));
  //   }, []);

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
    <div>
      <ul>
        {todos.map((t) => (
          <li
            className={
              t.status === "pending" ? styles.pending : styles.completed
            }
            key={t.id}
            onClick={() => toggleTodo(t.id)}
          >
            {t.text}
          </li>
        ))}
      </ul>
    </div>
  );
};
