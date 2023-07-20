import React from "react";
// import { useSelector } from "react-redux";
// import { NavLink } from "react-router-dom";
import styles from "../../styles/Sidebar.module.css";
import present from "../../images/подарок.png";

const Sidebar = () => { 
  return (
    <section className={styles.sidebar}> 
      <div className={styles.title}>Промокод</div>
      <div className={styles.info}>Скидка по промокоду ЦФТ!</div>
      <div className={styles.image}>
        <img src={present} alt="подарок" />
      </div>
    </section>
  );
};

export default Sidebar;
