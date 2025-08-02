import React from 'react';
import { mount, shallow } from 'enzyme';
import { render, fireEvent, waitFor, act } from '@testing-library/react';
import '@testing-library/jest-dom';
import Adapter from 'enzyme-adapter-react-16';
import Search, { Display } from './App.js';

// Set up Enzyme adapter
import { configure } from 'enzyme';
configure({ adapter: new Adapter() });

describe('Search component', () => {
  it('retrieves companyName from JSON file when the applicant is eligible', async () => {
    // Mount the component to interact with its DOM and state
    const wrapper = mount(<Search />);
    // Fill the form for a matching vacancy
    wrapper.find('input#name').simulate('change', { target: { value: 'Alice' } });
    wrapper.find('input#designation').simulate('change', { target: { value: 'Developer' } });
    wrapper.find('select#qualification').simulate('change', { target: { value: 'BE/BTech' } });
    wrapper.find('input#experience').simulate('change', { target: { value: 2 } });
    wrapper.find('input#location').simulate('change', { target: { value: 'New York' } });

    // Submit form
    await act(async () => {
      wrapper.find('button').simulate('click', { preventDefault() {} });
    });
    wrapper.update();

    // companyName should be set in state to "Tech Solutions Inc"
    expect(wrapper.state('companyName')).toBe('Tech Solutions Inc');
  });

  it('retrieves jobRole from JSON file when the applicant is eligible', async () => {
    // Mount and fill input for a matching vacancy
    const wrapper = mount(<Search />);
    wrapper.find('input#name').simulate('change', { target: { value: 'Bob' } });
    wrapper.find('input#designation').simulate('change', { target: { value: 'Engineer' } });
    wrapper.find('select#qualification').simulate('change', { target: { value: 'BE/BTech' } });
    wrapper.find('input#experience').simulate('change', { target: { value: 2 } });
    wrapper.find('input#location').simulate('change', { target: { value: 'New York' } });

    // Submit the form
    await act(async () => {
      wrapper.find('button').simulate('click', { preventDefault() {} });
    });
    wrapper.update();

    // jobRole should be "Software Engineer" from the JSON
    expect(wrapper.state('jobRole')).toBe('Software Engineer');
  });
});

describe('Display component', () => {
  it('renders properly with all prop values', () => {
    const { getByText } = render(
      <Display name="Charlie" jobRole="Web Developer" companyName="Web Wizards Ltd" />
    );
    expect(getByText(
      'Hey, Charlie. You can apply for the Web Developer job at Web Wizards Ltd Company.'
    )).toBeInTheDocument();
  });

  it('renders properly without prop values', () => {
    const { getByText } = render(
      <Display name="David" jobRole={null} companyName={null} />
    );
    expect(getByText(
      'Sorry David, currently there is no vacancy for your profile.'
    )).toBeInTheDocument();
  });
});
