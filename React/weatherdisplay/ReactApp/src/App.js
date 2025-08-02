import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { updateTemperature } from './Actions';
import './App.css';

function App() {
  // State for managing input field
  const [newTemperature, setNewTemperature] = useState('');
  
  // Get current temperature from Redux store
  const temperature = useSelector(state => state.temperature);
  
  // Get dispatch function
  const dispatch = useDispatch();
  
  // Handle form submission
  const handleUpdateTemperature = (e) => {
    e.preventDefault();
    if (newTemperature.trim() !== '') {
      dispatch(updateTemperature(parseFloat(newTemperature)));
      setNewTemperature(''); // Clear input field after submission
    }
  };
  
  return (
    <div className="weather-wrapper">
      <h1>Weather Display</h1>
      <div className="temperature-display">
        <h2>Current Temperature: {temperature}°C</h2>
      </div>
      <form onSubmit={handleUpdateTemperature}>
        <input
          type="number"
          value={newTemperature}
          onChange={(e) => setNewTemperature(e.target.value)}
          placeholder="Enter new temperature"
          step="0.1"
        />
        <button type="submit">Update Temperature</button>
      </form>
    </div>
  );
}

export default App;