package com.learnrulesengine.RulesEngine.controller;

import com.learnrulesengine.RulesEngine.DTO.CustomerDTO;
import com.learnrulesengine.RulesEngine.model.Customer;
import com.learnrulesengine.RulesEngine.model.Rules;
import com.learnrulesengine.RulesEngine.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiscountController {
    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService){
        this.discountService = discountService;
    }

    @PostMapping("/discount")
    public Customer getDiscount(@RequestBody CustomerDTO customer) {
        return discountService.applyDicount(customer);
    }

    @PostMapping("/createRule")
    public void createRuleAPI(@RequestBody Rules rules){

    }
}
