import React, { useState } from 'react';
import "./style.css";

const styles = {
    message: {
        height: "30px",
        width: "650px",
        backgroundColor: '#d3eaf1',
        padding: "3px",
        marginTop: "10px"
    },
    header: {
        height: "50px",
        color: 'white',
        padding: "10px",
        backgroundColor: '#81807E'
    },
    button: {
        backgroundColor: '#FDC30D',
        height: '40px',
        textAlign: 'center',
        width: '100px',
        border: 'none',
        cursor: 'pointer'
    }
};

const Recruiter = () => {
    const [companyName, setCompanyName] = useState('');
    const [jobType, setJobType] = useState('');
    const [jobLocation, setJobLocation] = useState('');
    const [experience, setExperience] = useState('');
    const [message, setMessage] = useState('');

    const handlePost = () => {
        if (companyName.trim()) {
            setMessage(`${companyName}, Your job requirement posted successfully`);
        } else {
            setMessage('');
        }
    };

    return (
        <div className='container w-50'>
            <div className="card">
                {/* Apply style directly to <h4> */}
                <h4 style={styles.header}>Recruiter</h4>

                <div className="card-body">
                    <div className="col align-items-center">
                        <div className="col">
                            <div className="p-2">
                                <input
                                    type="text"
                                    id="companyName"
                                    placeholder="Company Name"
                                    className='w-75 form-control form-control-sm'
                                    value={companyName}
                                    onChange={e => setCompanyName(e.target.value)}
                                />
                            </div>
                        </div>

                        <div className="col">
                            <div className="p-2">
                                <input
                                    type="text"
                                    id="jobType"
                                    placeholder="Job Type"
                                    className='w-75 form-control form-control-sm'
                                    value={jobType}
                                    onChange={e => setJobType(e.target.value)}
                                />
                            </div>
                        </div>

                        <div className="col">
                            <div className="p-2">
                                <input
                                    type="text"
                                    id="jobLocation"
                                    placeholder="Job Location"
                                    className='w-75 form-control form-control-sm'
                                    value={jobLocation}
                                    onChange={e => setJobLocation(e.target.value)}
                                />
                            </div>
                        </div>

                        <div className="col">
                            <div className="p-2">
                                <input
                                    type="text"
                                    id="experience"
                                    placeholder="Experience"
                                    className='w-75 form-control form-control-sm'
                                    value={experience}
                                    onChange={e => setExperience(e.target.value)}
                                />
                            </div>
                        </div>

                        <div className="col text-center">
                            <button
                                type="button"
                                style={styles.button}
                                id="post"
                                onClick={handlePost}
                            >
                                post
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div id="message" style={styles.message}>{message}</div>
        </div>
    );
}

export default Recruiter;
