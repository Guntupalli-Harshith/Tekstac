package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private double price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Long productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }
}