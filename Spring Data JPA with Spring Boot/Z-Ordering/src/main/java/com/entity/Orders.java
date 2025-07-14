package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product productObj;

    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "status")
    private String status; // "PLACED", "FAILED"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProductObj() {
        return productObj;
    }

    public void setProductObj(Product productObj) {
        this.productObj = productObj;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Orders(Long id, Product productObj, int quantity, String status) {
        this.id = id;
        this.productObj = productObj;
        this.quantity = quantity;
        this.status = status;
    }

    public Orders() {
    }
}