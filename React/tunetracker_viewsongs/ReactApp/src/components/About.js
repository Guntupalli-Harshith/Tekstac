import React from 'react';
import styles from './About.module.css';

const About = () => {
  return (
    <div className={styles.container}>
      <h1 className={styles.header}>About Our Song Management App</h1>
      <p className={styles.text}>
        Welcome to TuneTracker, your comprehensive song management application! 
        This innovative platform allows you to organize and manage your favorite 
        songs categorized by movies. Whether you're a music enthusiast, a movie buff, 
        or someone who loves the perfect soundtrack, TuneTracker provides an intuitive 
        interface to browse, search, and manage your music collection. Our application 
        features a clean, user-friendly design that makes it easy to discover and 
        organize songs from your favorite films. Start exploring and building your 
        personalized music database today!
      </p>
    </div>
  );
};

export default About;