package com.nttdata.customerCredit.operations;

import com.nttdata.customerCredit.domain.CustomerCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerCreditOperations {

    Flux<CustomerCredit> findAll() throws Exception;

    Mono<CustomerCredit> findById(Long id) throws Exception;

    Mono<CustomerCredit> save(CustomerCredit customerCredit) throws Exception;

    Mono<CustomerCredit> update(Long id, CustomerCredit customerCredit) throws Exception;

    Mono<Void> delete(Long id) throws Exception;
}
