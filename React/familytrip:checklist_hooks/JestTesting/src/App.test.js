import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from './App';

describe('App component', () => {
  it('adds a new item to the list when you click the Add button', () => {
    const { getByLabelText, getByText, getByDisplayValue } = render(<App />);
    const input = document.getElementById('checklistItems');
    const addButton = document.getElementById('add');

    fireEvent.change(input, { target: { value: 'Toothbrush' } });
    fireEvent.click(addButton);

    expect(getByText(/toothbrush/i)).toBeInTheDocument();
  });

  it('toggles the completion status of the list item', () => {
    const { getByText } = render(<App />);
    const input = document.getElementById('checklistItems');
    const addButton = document.getElementById('add');

    fireEvent.change(input, { target: { value: 'Toothbrush' } });
    fireEvent.click(addButton);

    const completeCheckbox = document.getElementById('checkbox-checked-0');
    fireEvent.click(completeCheckbox);

    expect(completeCheckbox.checked).toBe(true);
  });

  it('toggles the pending status of the list item', () => {
    const { getByText } = render(<App />);
    const input = document.getElementById('checklistItems');
    const addButton = document.getElementById('add');

    fireEvent.change(input, { target: { value: 'Shampoo' } });
    fireEvent.click(addButton);

    const pendingCheckbox = document.getElementById('checkbox-not-checked-0');
    fireEvent.click(pendingCheckbox);

    expect(pendingCheckbox.checked).toBe(false);
  });

  it('removes an item from the list when you click the Remove button', () => {
    const { getByText, queryByText } = render(<App />);
    const input = document.getElementById('checklistItems');
    const addButton = document.getElementById('add');

    fireEvent.change(input, { target: { value: 'Towel' } });
    fireEvent.click(addButton);

    const removeButton = getByText(/remove/i);
    fireEvent.click(removeButton);

    expect(queryByText(/towel/i)).not.toBeInTheDocument();
  });

  it('clears all items from the list', () => {
    const { getByText, queryByText } = render(<App />);
    const input = document.getElementById('checklistItems');
    const addButton = document.getElementById('add');

    fireEvent.change(input, { target: { value: 'Shoes' } });
    fireEvent.click(addButton);

    fireEvent.change(input, { target: { value: 'Snacks' } });
    fireEvent.click(addButton);

    const clearButton = document.getElementById('clear');
    fireEvent.click(clearButton);

    expect(queryByText(/shoes/i)).not.toBeInTheDocument();
    expect(queryByText(/snacks/i)).not.toBeInTheDocument();
  });

  it('displays the total number of items in the list correctly', () => {
    const { getByText } = render(<App />);
    const input = document.getElementById('checklistItems');
    const addButton = document.getElementById('add');

    fireEvent.change(input, { target: { value: 'Camera' } });
    fireEvent.click(addButton);

    fireEvent.change(input, { target: { value: 'Water bottle' } });
    fireEvent.click(addButton);

    expect(getByText(/total items: 2/i)).toBeInTheDocument();
  });

  it('displays the count of completed status items correctly', () => {
    const { getByText } = render(<App />);
    const input = document.getElementById('checklistItems');
    const addButton = document.getElementById('add');

    fireEvent.change(input, { target: { value: 'Map' } });
    fireEvent.click(addButton);

    const completeCheckbox = document.getElementById('checkbox-checked-0');
    fireEvent.click(completeCheckbox);

    expect(getByText(/completed items: 1/i)).toBeInTheDocument();
  });
});
