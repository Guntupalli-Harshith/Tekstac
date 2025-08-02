//Implement code for reducers
import { UPDATE_TEMPERATURE } from './Actions';

// Initial state with default temperature of 20
const initialState = {
  temperature: 20
};

// WeatherReducer function to manage temperature state
const WeatherReducer = (state = initialState, action) => {
  switch (action.type) {
    case UPDATE_TEMPERATURE:
      return {
        ...state,
        temperature: action.payload
      };
    default:
      return state;
  }
};

export default WeatherReducer;