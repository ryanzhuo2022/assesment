package com.ryan.reward.service;

import com.ryan.reward.dao.CustomerRepository;
import com.ryan.reward.dao.TransactionRepository;
import com.ryan.reward.entity.Customer;
import com.ryan.reward.entity.Transaction;
import com.ryan.reward.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    DateFormatter dateFormatter;

    @Override
    public Map<String, Integer> getRewardByIdWithinMonths(long id, int m) {
        Date d = dateFormatter.getDateMonthsAgo(m);
        Optional<Customer> customer = customerRepository.findById(id);
        List<Transaction> transactions = transactionRepository.findAllByCustomerIdWithTransactionDateBefore(customer.get(), d);
        Map<String, Integer> record = new HashMap<>();
        int totalReward = 0;
        for(Transaction transaction: transactions){
            int amount = (int) Math.floor(transaction.getAmount());
            Calendar cal = Calendar.getInstance();
            cal.setTime(transaction.getTransaction_date());
            String curr = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1);
            int reward = 0;
            if(amount > 100){
                reward = (amount-100) * 2 + 50 * 1;
            }
            else if(amount > 50){
                reward = (amount - 50) * 1;
            }
            record.put(curr, record.getOrDefault(curr, 0) + reward);
            totalReward += reward;
        }
        record.put("totalReward", totalReward);
        return record;
    }

    @Override
    public List<Map<String, Integer>> getRewards() {
        List<Customer> customers = customerRepository.findAll();
        List<Map<String, Integer>> rewards = new ArrayList<>();
        for(Customer customer: customers)
            rewards.add(getRewardByIdWithinMonths(customer.getId(), 3));
        return rewards;
    }

}
