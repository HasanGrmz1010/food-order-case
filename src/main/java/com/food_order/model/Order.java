package com.food_order.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    public Order() {}

    public Order(String customerName, Food food) {
        this.customerName = customerName;
        this.food = food;
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public Food getFood() { return food; }
    public void setFood(Food food) { this.food = food; }
}