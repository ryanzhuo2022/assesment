package com.ryan.reward;

import com.ryan.reward.controller.CustomerRestController;
import com.ryan.reward.dao.CustomerRepository;
import com.ryan.reward.dao.TransactionRepository;
import com.ryan.reward.service.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RewardApplicationTests {

	@Autowired
	CustomerRestController customerRestController;
	@Autowired
	CustomerService customerService;


	@Test
	public void testGetRewardById() {
		Map<String, Integer> reward1 = customerService.getRewardByIdWithinMonths(1, 3);
		assertEquals(reward1.get("total_reward"), 442);

		Map<String, Integer> reward2 = customerService.getRewardByIdWithinMonths(2, 3);
		assertEquals(reward2.get("total_reward"), 417);


	}

}
