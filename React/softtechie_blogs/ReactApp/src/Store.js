// Store.js
import { createStore } from 'redux';
import posts from './Reducers';

// Initialize Redux store with posts reducer
const store = createStore(posts);

export default store;