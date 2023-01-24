package com.ryan.reward.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Column(name = "name")
    private String name;

    @OneToMany()
    private List<Transaction> transactions;

}









