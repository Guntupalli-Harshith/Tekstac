import React, { useState, useEffect } from 'react';
import './style.css';

export default function Registration() {
    // Initialize state variables
    const [firstName, setFirstName] = useState(localStorage.getItem('firstName') || '');
    const [lastName, setLastName] = useState(localStorage.getItem('lastName') || '');
    const [email, setEmail] = useState(localStorage.getItem('email') || '');
    const [city, setCity] = useState('');
    const [activity, setActivity] = useState('');
    const [message, setMessage] = useState('');

    // useEffect hook to store values in localStorage whenever they change
    useEffect(() => {
        localStorage.setItem('firstName', firstName);
        localStorage.setItem('lastName', lastName);
        localStorage.setItem('email', email);
    }, [firstName, lastName, email]);

    // Event handlers
    const handleFirstNameChange = (e) => {
        setFirstName(e.target.value);
    }

    const handleLastNameChange = (e) => {
        setLastName(e.target.value);
    }

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    }

    const handleCityChange = (e) => {
        setCity(e.target.value);
    }

    const handleActivityChange = (e) => {
        setActivity(e.target.value);
    }

    const handleSubmit = () => {
        setMessage(`Hello ${firstName} ${lastName}, your registration has been confirmed for the ${activity} activity.`);
    }

    return (
        <div>
            <h2>Sun Shine Club Registration Form</h2>
            <table>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td>
                            <input
                                type="text"
                                id="firstName"
                                value={firstName}
                                onChange={handleFirstNameChange}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>
                            <input
                                type="text"
                                id="lastName"
                                value={lastName}
                                onChange={handleLastNameChange}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Email Id</td>
                        <td>
                            <input
                                type="text"
                                id="email"
                                value={email}
                                onChange={handleEmailChange}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td>
                            <input
                                type="text"
                                id="city"
                                value={city}
                                onChange={handleCityChange}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Activity Name</td>
                        <td>
                            <input
                                type="text"
                                id="activity"
                                value={activity}
                                onChange={handleActivityChange}
                            />
                        </td>
                    </tr>
                </tbody>
            </table>

            <button id="submit" onClick={handleSubmit}>Submit</button>

            <div id="result">
                {message}
            </div>
        </div>
    );
}
