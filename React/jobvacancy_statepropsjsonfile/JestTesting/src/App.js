import React, { Component } from 'react';
import './App.css';
import vacancyList from './vacancyList.json';

class Search extends Component {
  state = {
    name: null,
    designation: null,
    qualification: 'BE/BTech',
    experience: null,
    location: null,
    submitStatus: false,
    jobRole: null,
    companyName: null
  };

  searchVacancy() {
    const { name, qualification, experience, location } = this.state;
    let jobRole = null;
    let companyName = null;

    for (const vacancy of vacancyList) {
      if (
        vacancy.qualification.toLowerCase() === qualification.toLowerCase() &&
        vacancy.experienceRequired <= experience &&
        vacancy.city.toLowerCase() === location.toLowerCase()
      ) {
        jobRole = vacancy.jobRole;
        companyName = vacancy.companyName;
        break;
      }
    }

    this.setState({
      submitStatus: true,
      jobRole: jobRole,
      companyName: companyName,
    });
  };

  displayName = (event) => {
    this.setState({ name: event.target.value });
  };

  handleDesignation = (event) => {
    this.setState({ designation: event.target.value });
  };

  handleQualificationChange = (event) => {
    this.setState({ qualification: event.target.value });
  };

  handleExperienceChange = (event) => {
    this.setState({ experience: event.target.value });
  };

  handleLocationChange = (event) => {
    this.setState({ location: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    this.searchVacancy();
  };

  render() {
    return (
      <form>
        <div>
          <h2>EXCEL JOB ZONE CENTRE</h2>
        </div>
        <div>
          <label>Name</label>
          <br />
          <input id="name" type="text" onChange={this.displayName} />
          <br />
          <br />
          <label>Designation</label>
          <br />
          <input id="designation" type="text" onChange={this.handleDesignation} />
          <br />
          <br />
          <label>Qualification</label>
          <br />
          <select onChange={this.handleQualificationChange} id="qualification" value={this.state.qualification}>
            <option>BE/BTech</option>
            <option>ME/MTech</option>
            <option>BCA/MCA</option>
          </select>
          <br />
          <br />
          <label>Experience (in years)</label>
          <br />
          <input type="number" id="experience" onChange={this.handleExperienceChange} />
          <br />
          <br />
          <label>Current Location</label>
          <br />
          <input type="text" id="location" onChange={this.handleLocationChange} />
          <br />
          <br />
          <button onClick={this.handleSubmit}>Search Jobs</button>
          <br />
          <>
            {this.state.submitStatus && (
              <>
                <Display name={this.state.name} jobRole={this.state.jobRole} companyName={this.state.companyName} />
              </>
            )}
          </>
        </div>
      </form>
    );
  }
}

class Display extends Component {
  render() {
    return (
      <>
        <br />
        <div id="result">
          {this.props.jobRole
            ? `Hey, ${this.props.name}. You can apply for the ${this.props.jobRole} job at ${this.props.companyName} Company.`
            : `Sorry ${this.props.name}, currently there is no vacancy for your profile.`}
        </div>
      </>
    );
  }
}

export { Display };
export default Search;