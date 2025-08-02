import './style.css';
import productsData from './products.json';
import React, { useState, useEffect } from 'react';

function Async() {
    // State variable to store the products
    const [products, setProducts] = useState([]);

    // useEffect hook to fetch data when component mounts
    useEffect(() => {
        // Simulate fetching data from JSON file
        // In a real scenario, this might be an API call
        setProducts(productsData);
    }, []); // Empty dependency array means this effect runs once on mount

    return (
        <div>
            <h1>Products</h1>
            <ul>
                {products.map((product) => (
                    <li key={product.id}>
                        <strong>{product.name}</strong> - {product.brand}
                        <br />
                        Price: ${product.price}
                        <br />
                        Description: {product.description}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Async;