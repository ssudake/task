import React, { useState } from "react";
import styles from "./UserProfile.module.css";

export const UserPorfile = (props) => {
  const [firstname, setFirstname] = useState("anish");

  return (
    <div className={styles.container}>
      <div>
        <label>First name: </label>
        <input
          type="text"
          value={firstname}
          onChange={(e) => setFirstname(e.target.value)}>
        </input>
      </div>
    </div>
  );
};
