package com.ryan.reward.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_date")
    private Date transaction_date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public long getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }
    public Date getTransaction_date() {
        return transaction_date;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Long getCustomerId() {
        return customer.getId();
    }

}
