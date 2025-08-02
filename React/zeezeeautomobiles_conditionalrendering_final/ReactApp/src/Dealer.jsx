import "./styles.css";
import React, { useState } from 'react';

const DealerBoard = () => {
    const [flag, setFlag] = useState(0);  // flag state

    const changeHandler = (e) => {
        if (e.target.name === 'sales') {
            setFlag(1);
        } else if (e.target.name === 'service') {
            setFlag(2);
        }
    }

    const getReport = () => {
        if (flag === 1) {
            return <SalesReport />;
        } else if (flag === 2) {
            return <ServiceReport />;
        }
        return null;
    }

    return (
        <div>
            <h3 className="bg-info text-white d-inline-block">ZeeZee Automobiles</h3>
            <br /><br />
            <button className="btn btn-warning" name="sales" onClick={changeHandler}>Sales Report</button>
            <span> </span>
            <button className="btn btn-info" name="service" onClick={changeHandler}>Service Report</button>
            <br /><br />
            <div>{getReport()}</div>
        </div>
    )
}

const SalesReport = () => {
    return (
        <table className="table table-hover bg-secondary w-50 text-white">
            <thead>
                <tr className="font-weight-bold">
                    <th>Owner Name</th>
                    <th>Contact Number</th>
                    <th>Model</th>
                    <th>Date of Purchase</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Alwin</td>
                    <td>+13044000354</td>
                    <td>Hundai Creta</td>
                    <td>23-7-2021</td>
                </tr>
                <tr>
                    <td>Hendry</td>
                    <td>+15044000354</td>
                    <td>Ford Eco sport</td>
                    <td>01-7-2022</td>
                </tr>
            </tbody>
        </table>
    )
}

const ServiceReport = () => {
    return (
        <table className="table table-hover bg-secondary w-50 text-white">
            <thead>
                <tr className="font-weight-bold">
                    <th>Vehicle Number</th>
                    <th>Contact Number</th>
                    <th>Service Type</th>
                    <th>Service charge</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>85863NY16</td>
                    <td>+12044000354</td>
                    <td>Ac service</td>
                    <td>25$</td>
                </tr>
                <tr>
                    <td>120665NY16</td>
                    <td>+15544000354</td>
                    <td>Wheel alignment</td>
                    <td>12$</td>
                </tr>
            </tbody>
        </table>
    )
}

export { SalesReport };
export { ServiceReport };
export default DealerBoard;
