package com.nihir.relationshipannotations.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @com.fasterxml.jackson.annotation.JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    // 🔥 THIS METHOD MUST EXIST
    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    // getters & setters
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
