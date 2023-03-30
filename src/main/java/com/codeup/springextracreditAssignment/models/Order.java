package com.codeup.springextracreditAssignment.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 60)
    private String email;
    @Column(nullable = false)
    private Double totalPrice;

    public Order() {
    }

    public Order(long id, String email, Double totalPrice) {
        this.id = id;
        this.email = email;
        this.totalPrice = totalPrice;
    }

    public Order(String email, Double totalPrice) {
        this.email = email;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
