package com.ryan.reward.service;

import com.ryan.reward.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Map<String, Integer> getRewardByIdWithinMonths(long id, int month);
    List<Map<String, Integer>> getRewards();

    Customer findById(long id);
}
