package com.learnrulesengine.RulesEngine.service;

import com.learnrulesengine.RulesEngine.model.Customer;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    private final KieContainer kieContainer;

    public DiscountService(KieContainer kieContainer){
        this.kieContainer = kieContainer;
    }

    public Customer applyDicount(Customer customer){
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(customer);
        kieSession.fireAllRules();
        kieSession.dispose();
        return customer;
    }
}
