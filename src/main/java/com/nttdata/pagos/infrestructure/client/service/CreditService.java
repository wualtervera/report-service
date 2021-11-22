package com.nttdata.pagos.infrestructure.client.service;

import com.nttdata.pagos.infrestructure.client.model.Credit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CreditService{

    WebClient webClient = WebClient.create("http://localhost:8001/api/v1");

    //Metodo para traer la data del credito
    public Mono<Credit> findIdCredit(Long idCredit) { //Busca creditos por idcredit
        return webClient.get()
                .uri("/credit/getCredit/"+idCredit)
                .accept(MediaType.APPLICATION_NDJSON)
                .retrieve()
                .bodyToMono(Credit.class);
    }

    //Metodo para actualizar la data de credito cuando se realizasn consumos
    public Mono<Credit> expense(Credit credit, Long iCredit) {
        return webClient.put()
                .uri("/credit/update/"+iCredit)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(credit), Credit.class)
                .retrieve()
                .bodyToMono(Credit.class);

    }

    //Metodo para actualizar la data de credito cuando se realizasn pagos
    public Mono<Credit> payment(Credit credit, Long idCredit) {
        return webClient.put()
                .uri("/credit/update/"+idCredit)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(credit), Credit.class)
                .retrieve()
                .bodyToMono(Credit.class);
    }
}
