import { createStore } from 'redux';
// import reducer
import WeatherReducer from './Reducers';

// implement code for store
const WeatherStore = createStore(WeatherReducer);

export default WeatherStore;