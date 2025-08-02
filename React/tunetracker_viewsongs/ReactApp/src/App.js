import React from 'react';
import { Route, Routes, Link } from 'react-router-dom';
import About from './components/About.js';
import Songs from './components/Songs.js';

function App() {
  return (
    <div>
      <h1><span>Tune</span>Tracker</h1>
      <nav>
        <ul>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/songs">Songs</Link></li>
        </ul>
      </nav>
      
      <Routes>
        <Route path="/about" element={<About />} />
        <Route path="/songs" element={<Songs />} />
      </Routes>
    </div>
  );
}

export default App;