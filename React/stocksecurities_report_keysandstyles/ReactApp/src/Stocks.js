import React, { Component } from 'react';

var data = [
  { id: "ST1", Stock: "Apple", Price: "$150" },
  { id: "ST2", Stock: "Amazon", Price: "$3500" },
  { id: "ST3", Stock: "Alibaba Group", Price: "$175" },
  { id: "ST4", Stock: "Johnson & Johnson", Price: "$160" },
];

const styles = {
  tableCSS: {
    border: '1px solid black',
    borderCollapse: 'collapse',
  },
  tdCSS: {
    border: '1px solid black',
    width: '100px',
    borderCollapse: 'collapse',
    padding: '15px',
    textAlign: 'left',
  }
};

class Stocks extends Component {
  constructor(props) {
    super(props);
    this.state = {
      stocks: data
    };
  }

  render() {
    return (
      <div>
        <h1 style={{ textAlign: "center" }}> STOCK SECURITIES</h1>
        <h2 style={{ textAlign: "center" }}>REPORT</h2>

        <table style={styles.tableCSS} align="center">
          <thead>
            <tr>
              <th style={styles.tdCSS}>ID</th>
              <th style={styles.tdCSS}>Stock</th>
              <th style={styles.tdCSS}>Price</th>
            </tr>
          </thead>
          <tbody>
            {this.state.stocks.map((stock) => (
              <Display key={stock.id} stocks={stock} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

class Display extends Component {
  render() {
    const { stocks } = this.props;
    return (
      <tr>
        <td style={styles.tdCSS}>{stocks.id}</td>
        <td style={styles.tdCSS}>{stocks.Stock}</td>
        <td style={styles.tdCSS}>{stocks.Price}</td>
      </tr>
    );
  }
}

export { Display };
export default Stocks;