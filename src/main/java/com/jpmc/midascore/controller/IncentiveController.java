package com.jpmc.midascore.controller;

import com.jpmc.midascore.foundation.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncentiveController {
    
    private static final Logger logger = LoggerFactory.getLogger(IncentiveController.class);
    
    @PostMapping("/incentive")
    public Incentive calculateIncentive(@RequestBody Transaction transaction) {
        logger.info("Received incentive request for transaction: {}", transaction);
        
        // Simple incentive calculation logic - you can modify this as needed
        // For example: 5% of transaction amount as incentive
        float incentiveAmount = transaction.getAmount() * 0.05f;
        
        // Ensure incentive is >= 0
        if (incentiveAmount < 0) {
            incentiveAmount = 0.0f;
        }
        
        Incentive incentive = new Incentive(incentiveAmount);
        logger.info("Calculated incentive: {}", incentive);
        
        return incentive;
    }
}