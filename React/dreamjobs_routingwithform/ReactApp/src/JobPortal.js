import React from 'react';
import { Link, Routes, Route } from 'react-router-dom';
import JobSeeker from './JobSeeker';
import Recruiter from './Recruiter';
import "./style.css";

const styles = {
    title: {
        height: "100px",
        width: "1550px",
        color: 'white',
        backgroundColor: '#FDC30D',
        padding: "25px"
    },
    menu: {
        display: 'flex',
        gap: '2rem',
        margin: '25px'
    },
    link: {
        fontSize: '1.2rem',
        textDecoration: 'none',
        color: '#23609f',
        fontWeight: 'bold'
    }
};

const JobPortal = () => {
    return (
        <>
            {/* Apply style directly to <h2> as required */}
            <h2 style={styles.title}>Dream Jobs</h2>

            <div style={styles.menu}>
                <Link to="/jobseeker" style={styles.link}>Job Seeker</Link>
                <Link to="/recruiter" style={styles.link}>Recruiter</Link>
            </div>

            <Routes>
                <Route path="/jobseeker" element={<JobSeeker />} />
                <Route path="/recruiter" element={<Recruiter />} />
            </Routes>
        </>
    );
};

export default JobPortal;
