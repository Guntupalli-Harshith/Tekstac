// Please do not make any changes in the given code template

import React, { useState } from 'react';
import './styles.css';

const CourseDetails = () => {
    // Create state variable 'course' using useState() hook
    const [course, setCourse] = useState('');

    // Handle dropdown change event
    const handleCourseChange = (event) => {
        setCourse(event.target.value);
    };

    return (
        <div>
            <h1>BETA - The Excellence Park</h1>
            <label>Pick your study path:</label>
            
            {/* Dropdown with id "course" and onChange event */}
            <select id="course" value={course} onChange={handleCourseChange}>
                <option value="">-- Select a course --</option>
                <option value="Python">Python</option>
                <option value="ReactJS">ReactJS</option>
                <option value="Angular">Angular</option>
            </select>
            
            {/* Display selected course in h4 element */}
            {course && (
                <h4>Choosen Study Path: {course}</h4>
            )}
        </div>
    );
};

export default CourseDetails;