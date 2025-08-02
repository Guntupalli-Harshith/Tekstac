import React, { createContext, useState, useEffect } from 'react';
import axios from 'axios';

// Create the SongContext
export const SongContext = createContext();

const SongProvider = ({ children }) => {
  // Initialize songs state as an empty array
  const [songs, setSongs] = useState([]);

  // Function to fetch songs from the API
  const fetchSongs = async () => {
    try {
      const response = await axios.get('http://lmsreact.tekstac.com:3001/songs');
      setSongs(response.data);
    } catch (error) {
      console.error('Error fetching songs:', error);
    }
  };

  // Use useEffect to fetch songs when component mounts
  useEffect(() => {
    fetchSongs();
  }, []);

  return (
    <SongContext.Provider value={{ songs, setSongs }}>
      {children}
    </SongContext.Provider>
  );
};

export default SongProvider;