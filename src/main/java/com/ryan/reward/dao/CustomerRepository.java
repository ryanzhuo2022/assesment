package com.ryan.reward.dao;

import com.ryan.reward.entity.Customer;
import com.ryan.reward.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
