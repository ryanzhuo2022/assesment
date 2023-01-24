package com.ryan.reward.dao;

import com.ryan.reward.entity.Customer;
import com.ryan.reward.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select a from Transaction a where a.customer = :customer AND a.transaction_date >= :transaction_date")
    List<Transaction> findAllByCustomerIdWithTransactionDateBefore(@Param("customer") Customer customer,
            @Param("transaction_date") Date transactionDate);

}
