package com.nttdata.customerCredit.infrestructure.spring.config;


import com.nttdata.customerCredit.infrestructure.service.CustomerCreditCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {


    @Bean
    public CustomerCreditCrudService customerCreditRepository(){
        return new CustomerCreditCrudService();

    }
}
