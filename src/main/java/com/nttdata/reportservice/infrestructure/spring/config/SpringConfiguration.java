package com.nttdata.reportservice.infrestructure.spring.config;


import com.nttdata.reportservice.infrestructure.res.service.ReportCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public ReportCrudService reportRepository(){
        return new ReportCrudService();

    }
}
