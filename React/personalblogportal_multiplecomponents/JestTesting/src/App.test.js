// Do not include any other packages other than the following packages
import { render, fireEvent, screen } from '@testing-library/react';
import React from 'react';
import '@testing-library/jest-dom';
import App from './App.js';

// Note: Importing Blog and FollowersCount from the same file as App.js.
// But for direct rendering, we need to access the classes.
// We'll just test against rendered output via App/props as shown below.

// Blog component
describe('Blog component', () => {
    it('renders blog information correctly', () => {
        // Render the App (which contains Blog as a child)
        render(<App />);
        // Avatar icon
        expect(screen.getByText('😎')).toBeInTheDocument();
        // Name
        expect(screen.getByText('Dr.Priscilla Jegan')).toBeInTheDocument();
        // Profession
        expect(screen.getByText('Medico')).toBeInTheDocument();
        // University
        expect(screen.getByText('SRMite')).toBeInTheDocument();
        // Follow button
        expect(screen.getByText('Follow')).toBeInTheDocument();
        // Followers count
        expect(screen.getByText(/Followers:/)).toBeInTheDocument();
    });
});

describe('FollowersCount component', () => {
    it('initial followers count is 0', () => {
        render(<App />);
        // Followers count at start
        expect(screen.getByText('Followers: 0')).toBeInTheDocument();
    });

    it('increments followers count when the Follow button is clicked', () => {
        render(<App />);
        const followButton = screen.getByText('Follow');
        // Click once, should go from 0 -> 1
        fireEvent.click(followButton);
        expect(screen.getByText('Followers: 1')).toBeInTheDocument();
        // Click again, should go to 2
        fireEvent.click(followButton);
        expect(screen.getByText('Followers: 2')).toBeInTheDocument();
    });
});
