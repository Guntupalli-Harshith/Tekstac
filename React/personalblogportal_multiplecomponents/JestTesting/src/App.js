import React, { Component } from 'react';

class FollowersCount extends Component {
  render() {
    return (
      <div style={{ fontSize: '18px', marginTop: '10px' }}>
        <b>Followers: {this.props.count}</b>
      </div>
    );
  }
}

class Blog extends Component {
  render() {
    return (
      <div style={{ margin: '50px', fontFamily: 'Arial, sans-serif' }}>
       {/*<h2 style={{ marginBottom: '20px' }}>Personal Blog</h2>*/}
        <div style={{ display: 'flex', alignItems: 'center', marginBottom: '20px' }}>
          <span style={{ border: '2px solid black', width: '50px', fontSize: '35px', marginRight: '10px', padding:'5px' }}>&#128526;</span>
          <div>
            <b style={{ fontSize: '20px' }}>Dr.Priscilla Jegan</b><br />
            <span style={{ fontSize: '16px' }}>Medico</span><br />
            <span style={{ fontSize: '16px' }}>SRMite</span>
          </div>
        </div>
        <button
          style={{ backgroundColor: 'blue', color: 'white', borderRadius: '5px', padding: '10px 20px', fontSize: '16px', cursor: 'pointer' }}
          onClick={this.props.onFollow}
        >
          Follow
        </button>
        <p>
          <mark>
            <FollowersCount count={this.props.followersCount} />
          </mark>
        </p>
      </div>
    );
  }
}

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      followersCount: 0,
    };
  }

  incrementCount = () => {
    this.setState((prevState) => ({
      followersCount: prevState.followersCount + 1,
    }));
  };

  render() {
    return (
      <div style={{ border: '2px double #000000', display:'inline-block', margin:'50px'}}>
        <h1 style={{ textAlign: 'center' }}>Personal Blog</h1>
        <Blog onFollow={this.incrementCount} followersCount={this.state.followersCount} />
      </div>
    );
  }
}

export default App;
