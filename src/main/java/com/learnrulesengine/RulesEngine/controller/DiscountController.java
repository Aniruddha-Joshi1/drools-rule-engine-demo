package com.learnrulesengine.RulesEngine.controller;

import com.learnrulesengine.RulesEngine.model.Customer;
import com.learnrulesengine.RulesEngine.service.DiscountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiscountController {
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService){
        this.discountService = discountService;
    }

    @PostMapping("/discount")
    public Customer getDiscount(@RequestBody Customer customer) {
        return discountService.applyDicount(customer);
    }
}
