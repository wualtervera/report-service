package com.nttdata.customerCredit.model;

import com.nttdata.customerCredit.domain.CustomerCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerCreditRepository {

    Flux<CustomerCredit> findAll();

    Mono<CustomerCredit> findById(Long id);

    Mono<CustomerCredit> save(CustomerCredit customerCredit);

    Mono<CustomerCredit> update(Long id, CustomerCredit customerCredit);

    Mono<Void> delete(Long id);
}
