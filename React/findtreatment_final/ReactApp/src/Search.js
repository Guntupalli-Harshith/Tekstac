// Please do not make any changes in the given template
import React, { useState } from 'react';
import './styles.css';

var treatmentList = ["Keratin", "Scalp", "Moisture", "Detox", "Toning"];

// Display Component
function Display(props) {
    // props.treatments is an array of result strings
    return (
        <div>
            {props.treatments && props.treatments.map((result, idx) => (
                <h3 key={idx}>{result}</h3>
            ))}
        </div>
    );
}

// Search Component
function Search() {
    // Treatments to show as options
    const options = ["Keratin", "Scalp", "Moisture", "Relax", "Cysteine"];

    // useState for resultant array
    const [results, setResults] = useState([]);

    // Handle label click
    const handleSearch = (treatment) => {
        // Check if treatment is in treatmentList
        const found = treatmentList.includes(treatment);
        // Create result string
        const resultString = found ? `${treatment} - Found` : `${treatment} - Not Found`;
        // Update results state (show only the current clicked result as per sample)
        setResults([resultString]);
    };

    return (
        <div>
            <h1> Hair Shine</h1>
            <div>
                {options.map((treat, idx) => (
                    <label
                        key={idx}
                        style={{ marginRight: "20px", cursor: "pointer", fontSize: "20px" }}
                        onClick={() => handleSearch(treat)}
                    >
                        {treat}
                    </label>
                ))}
            </div>
            {/* Send results to Display as treatments prop */}
            <Display treatments={results} />
        </div>
    );
}

export { Display };
export default Search;
