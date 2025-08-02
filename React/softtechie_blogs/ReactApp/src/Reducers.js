// Reducers.js
import { ADD_POST } from './Actions';

// Initial state
const initialState = {
  posts: []
};

// Create posts reducer function
const posts = (state = initialState, action) => {
  switch (action.type) {
    case ADD_POST:
      return {
        ...state,
        posts: [
          ...state.posts,
          {
            id: state.posts.length + 1,
            title: action.title,
            content: action.content
          }
        ]
      };
    default:
      return state;
  }
};

export default posts;