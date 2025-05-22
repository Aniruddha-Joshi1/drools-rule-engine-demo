package com.learnrulesengine.RulesEngine.service;

import com.learnrulesengine.RulesEngine.DTO.CustomerDTO;
import com.learnrulesengine.RulesEngine.model.Customer;
import com.learnrulesengine.RulesEngine.repository.CustomerRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    private final KieContainer kieContainer;
    private final CustomerRepository customerRepository;

    @Autowired
    public DiscountService(KieContainer kieContainer, CustomerRepository customerRepository) {
        this.kieContainer = kieContainer;
        this.customerRepository = customerRepository;
    }

    public Customer applyDicount(CustomerDTO customer){
        KieSession discountSession = kieContainer.newKieSession("discountKSession");
        discountSession.insert(customer);
        discountSession.fireAllRules();
        discountSession.dispose();

        KieSession specialSession = kieContainer.newKieSession("specialCustomerKSession");
        specialSession.insert(customer);
        specialSession.fireAllRules();
        specialSession.dispose();

        Customer neededCustomer = new Customer(customer);
        customerRepository.save(neededCustomer);
        return neededCustomer;
    }
}
