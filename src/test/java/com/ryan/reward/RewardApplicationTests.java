package com.ryan.reward;

import com.ryan.reward.controller.CustomerRestController;
import com.ryan.reward.dao.CustomerRepository;
import com.ryan.reward.dao.TransactionRepository;
import com.ryan.reward.entity.Customer;
import com.ryan.reward.entity.Transaction;
import com.ryan.reward.service.CustomerService;
import com.ryan.reward.utils.DateFormatter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RewardApplicationTests {

	@Autowired
	CustomerRestController customerRestController;
	@Autowired
	CustomerService customerService;
	@Autowired
	TransactionRepository transactionRepository;

	@Test
	public void testGetRewardById() {
		Map<String, Integer> reward1 = customerService.getRewardByIdWithinMonths(1, 3);
		assertEquals(reward1.get("total_reward"), 442);

		Map<String, Integer> reward2 = customerService.getRewardByIdWithinMonths(2, 3);
		assertEquals(reward2.get("total_reward"), 417);
	}

	@Test
	public void testGetReward(){
		List<Map<String, Integer>> rewards = customerService.getRewards();
		assertEquals(rewards.size(), 2);
		assertEquals(rewards.get(0).get("total_reward"), 442);
		assertEquals(rewards.get(1).get("total_reward"), 417);
	}
	@Test
	public void testCustomer(){
		Customer customer1 = customerService.findById(1);
		assertEquals(customer1.getTransactions().size(), 8);
		assertEquals(customer1.getName(), "ryan");
		Customer customer2 = customerService.findById(2);
		assertEquals(customer2.getTransactions().size(), 5);
		assertEquals(customer2.getName(), "yanpeng");
	}

	@Test
	public void testTransaction(){
		Transaction transaction = transactionRepository.findById(Long.valueOf(1)).orElse(null);
		assertEquals(transaction.getAmount(), 125.2);
		assertEquals(transaction.getCustomerId(), 1);
	}

}
