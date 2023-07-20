import React from "react";
import { Link } from "react-router-dom";

import styles from "../../styles/Footer.module.css";
import { ROUTES } from "../../utils/routes";

import LOGO from "../../images/SibFast.png";

const Footer = () => (
  <section className={styles.footer}>
    <div className={styles.logo}>
      <Link to={ROUTES.HOME}>
        <img src={LOGO} alt="CHAMPIONS" />
      </Link>
    </div>
    <div className={styles.centers}>
      Developed by CHAMPIONS
    </div>
    <div className={styles.rights}>
      Сделано при прохождении<br/> ШИФТ 2023 <br />champions@cft.ru
    </div>
  </section>
);

export default Footer;
