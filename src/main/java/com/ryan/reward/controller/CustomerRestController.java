package com.ryan.reward.controller;

import com.ryan.reward.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/reward/{customerId}")
    public ResponseEntity<Map<String, Integer>> getRewardByCustomerId(@PathVariable long customerId){
        Map<String, Integer> reward = customerService.getRewardByIdWithinMonths(customerId, 3);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }
    @GetMapping("/reward")
    public ResponseEntity<List<Map<String, Integer>>> getRewards(){
        List<Map<String, Integer>> rewards = customerService.getRewards();
        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }
}
