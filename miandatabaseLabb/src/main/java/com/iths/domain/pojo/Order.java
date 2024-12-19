package com.iths.domain.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")  // Table name in the database
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)  // Foreign key column
    private int userId;

    @Column(name = "total_fee")
    private double totalFee;

    // Constructors, getters and setters
    public Order() {}

    public Order(int id, int userId, double totalFee) {
        this.id = id;
        this.userId = userId;
        this.totalFee = totalFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }
}
