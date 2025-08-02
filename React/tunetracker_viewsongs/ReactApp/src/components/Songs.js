import React, { useContext } from 'react';
import { SongContext } from '../context/SongsContext';
import styles from './Songs.module.css';

const Songs = () => {
  const { songs } = useContext(SongContext);

  return (
    <div className={styles.container}>
      <h1 className={styles.header}>Songs</h1>
      
      <table className={styles.table}>
        <thead>
          <tr>
            <th>Movie Name</th>
            <th>Song</th>
            <th>Duration</th>
          </tr>
        </thead>
        <tbody>
          {songs.map((song, index) => (
            <tr key={index}>
              <td>{song.movieName}</td>
              <td>{song.song}</td>
              <td>{song.duration}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Songs;