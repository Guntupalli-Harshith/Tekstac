//Implement action creators and type

// Step 1: Define action type constant
export const UPDATE_TEMPERATURE = 'UPDATE_TEMPERATURE';

// Step 2: Implement updateTemperature action creator
export const updateTemperature = (temperature) => ({
  type: UPDATE_TEMPERATURE,
  payload: temperature
});