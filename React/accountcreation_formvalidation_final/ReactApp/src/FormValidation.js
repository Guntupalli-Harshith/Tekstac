import React, { Component } from 'react';
import './styles.css';

class FormValidation extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            usernameerror: '',
            passworderror: ''
        };
    }

    usernamechangeHandler = (event) => {
        this.setState({
            username: event.target.value,
            usernameerror: ''
        });
    }

    passwordchangeHandler = (event) => {
        this.setState({
            password: event.target.value,
            passworderror: ''
        });
    }

    validateForm = (event) => {
        event.preventDefault();
        
        const { username, password } = this.state;
        let isValid = true;

        // Check if username is empty
        if (!username.trim()) {
            this.setState({ usernameerror: 'Username cannot be empty' });
            isValid = false;
        } else {
            // Username pattern: must begin with a letter, 7-14 characters total, 
            // remaining characters can be letters, digits, or whitespace
            const usernamePattern = /^[a-zA-Z][a-zA-Z0-9\s]{6,13}$/;
            if (!usernamePattern.test(username)) {
                this.setState({ usernameerror: 'Username did not meet the required pattern' });
                isValid = false;
            }
        }

        // Check if password is empty
        if (!password.trim()) {
            this.setState({ passworderror: 'Password cannot be empty' });
            isValid = false;
        } else {
            // Password pattern: 5-15 characters, at least one digit, one lowercase letter,
            // one uppercase letter, and one special character from @,_,$,#,*
            const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@_$#*]).{5,15}$/;
            if (!passwordPattern.test(password)) {
                this.setState({ passworderror: 'Password did not satisfy the required pattern' });
                isValid = false;
            }
        }

        if (isValid) {
            this.submitForm();
        }
    }

    submitForm = () => {
        const { username } = this.state;
        alert(`Your account has been created successfully!!! \n Welcome ${username}`);
    }

    render() {
        const { username, password, usernameerror, passworderror } = this.state;

        return (
            <div>
                <h1>Tekstac-The Learning Platform</h1>
                <h3>SIGN UP</h3>
                <form onSubmit={this.validateForm}>
                    <label htmlFor="username">User Name</label><br />
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={this.usernamechangeHandler}
                    />
                    <span>{usernameerror}</span><br /><br />

                    <label htmlFor="password">Password</label><br />
                    <input
                        type="text"
                        id="password"
                        value={password}
                        onChange={this.passwordchangeHandler}
                    />
                    <span>{passworderror}</span><br /><br />

                    <button type="submit">Submit</button>
                </form>
            </div>
        );
    }
}

export default FormValidation;