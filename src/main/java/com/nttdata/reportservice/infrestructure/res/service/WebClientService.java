package com.nttdata.reportservice.infrestructure.res.service;

import com.nttdata.reportservice.infrestructure.model.dto.AccountDto;
import com.nttdata.reportservice.infrestructure.model.dto.CreditDto;
import com.nttdata.reportservice.infrestructure.model.dto.CustomerDto;
import com.nttdata.reportservice.infrestructure.model.dto.TransactionsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Component
public class WebClientService {

    WebClient webClient = WebClient.create("http://localhost:8080/api/v1");

    public Flux<CreditDto> getCredits(String idCustomer) {
        log.info("Entre a getCredits - EN CREDITS SERVICE");
        return webClient.get()
                .uri("/credit/customer/{idCustomer}", idCustomer)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CreditDto.class);
    }

    public Mono<CreditDto> getCredit(String idCrdit) {
        return webClient.get()
                .uri("/credit/{idCrdit}", idCrdit)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CreditDto.class);
    }

    public Flux<CreditDto> getAccounts(String idCrdit) {
        return webClient.get()
                .uri("/credit/customer/{idCrdit}", idCrdit)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CreditDto.class);
    }

    //Traendo datos otrs servicios relacionados con client
    public Mono<AccountDto> getAccount(String idAccoun) {
        return webClient.get()
                .uri("/account/{idAccoun}", idAccoun)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AccountDto.class);
    }

    public Mono<CustomerDto> getCustomer(String idCustomer) {
        return webClient.get()
                .uri("/customers/{idCustomer}", idCustomer)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CustomerDto.class);
    }

    public Flux<TransactionsDto> getTransactionProduct(String idProduct) {
        return webClient.get()
                .uri("/transaction/product/{idProduct}", idProduct)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(TransactionsDto.class);
    }

}
