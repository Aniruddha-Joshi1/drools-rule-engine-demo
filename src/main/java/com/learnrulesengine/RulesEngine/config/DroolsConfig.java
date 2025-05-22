package com.learnrulesengine.RulesEngine.config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
    @Bean
    public KieContainer kieContainer(){
        // entry point to Drools API - used to access everything in Drools engine
        KieServices kieServices = KieServices.Factory.get();
        // in memory file sys for our rule file
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write(ResourceFactory.newClassPathResource("rules/discount.drl"));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Error building Drools rules: " + kieBuilder.getResults());
        }
        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId releaseId = kieRepository.getDefaultReleaseId();
        return kieServices.newKieContainer(releaseId);
    }
}
