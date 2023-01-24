package com.ryan.reward;

import com.ryan.reward.controller.CustomerRestController;
import com.ryan.reward.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RewardApplicationTests {

	@Autowired
	CustomerRestController customerRestController;
	@Autowired
	CustomerService customerService;
	@Test
	void testGetReward() {
		Map<String, Integer> reward = customerService.getRewardByIdWithinMonths(1, 3);
		System.out.println(reward.toString());
		Date d = new Date();
		System.out.println(d.getYear());
	}

}
