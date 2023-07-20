import React from "react";

import styles from "../../styles/Home.module.css";

import BG from "../../images/курьер.png";

const Poster = () => (
  <section className={styles.home}>
    <div className={styles.product}>
      <div className={styles.text}>
        <h1 className={styles.head}>Доставим любой товар к вам</h1>
      </div>
      <div className={styles.image}>
        <img src={BG} alt="" />
      </div>
    </div>
  </section>
);

export default Poster;
