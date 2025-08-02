import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router } from 'react-router-dom';
import JobPortal from './JobPortal';

ReactDOM.render(
    <Router>
        <JobPortal />
    </Router>,
    document.getElementById('root')
);
