import React, { useReducer } from 'react';
import './App.css';

const todoReducer = (state, action) => {
  switch (action.type) {
    case 'add':
      return [...state, { text: action.payload, completed: false }];
    case 'remove':
      return state.filter((_, index) => index !== action.payload);
    case 'clearAll':
      return [];
    case 'toggle':
      const updatedTodos = [...state];
      updatedTodos[action.payload].completed = !updatedTodos[action.payload].completed;
      return updatedTodos;
    default:
      return state;
  }
};

const App = () => {
  const [todos, dispatch] = useReducer(todoReducer, []);

  const handleToggle = (index) => {
    dispatch({ type: 'toggle', payload: index });
  };

  const handleRemove = (index) => {
    dispatch({ type: 'remove', payload: index });
  };

  const handleClearAll = () => {
    dispatch({ type: 'clearAll' });
  };

  return (
    <div>
      <h2 style={{ marginLeft: '7px' }}>Family trip - Checklist</h2>
      <br />
      <form
        onSubmit={(event) => {
          event.preventDefault();
          const todo = event.target.elements.todo.value.trim();
          if (todo !== '') {
            dispatch({ type: 'add', payload: todo });
            event.target.elements.todo.value = '';
          }
        }}
      >
        &ensp;
        <input type="text" name="todo" id="checklistItems" />&ensp;
        <button id="add" type="submit">Add</button>
      </form>
      <br />
      {todos.length > 0 && (
        <div>
          <table>
            <thead>
              <tr>
                <th style={{ paddingRight: '20px' }}>Item List</th>
                <th>Completed</th>
                <th>Pending</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {todos.map((todo, index) => (
                <tr key={index}>
                  <td>{todo.text}</td>
                  <td>
                    <input
                      id={`checkbox-checked-${index}`}
                      type="checkbox"
                      name={`todo-checkbox-${index}`}
                      checked={todo.completed}
                      onChange={() => handleToggle(index)}
                    />
                  </td>
                  <td>
                    <input
                      id={`checkbox-not-checked-${index}`}
                      type="checkbox"
                      name={`todo-checkbox-${index}`}
                      checked={!todo.completed}
                      onChange={() => handleToggle(index)}
                    />
                  </td>
                  <td>
                    <button className="remove" type="button" onClick={() => handleRemove(index)}>
                      Remove
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <div id="report">
            <p>Total Items: {todos.length}</p>
            <p>Completed Items: {todos.filter((todo) => todo.completed).length}</p>
            <button type="button" id="clear" onClick={handleClearAll}>
              Clear All Items
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default App;