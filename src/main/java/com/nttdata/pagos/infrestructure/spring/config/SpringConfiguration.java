package com.nttdata.pagos.infrestructure.spring.config;


import com.nttdata.pagos.infrestructure.res.service.PagosCrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {


    @Bean
    public PagosCrudService pagosRepository(){
        return new PagosCrudService();

    }
}
