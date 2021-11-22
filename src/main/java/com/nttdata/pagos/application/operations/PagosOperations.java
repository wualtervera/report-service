package com.nttdata.pagos.application.operations;

import com.nttdata.pagos.application.domain.Pagos;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerCreditOperations {

    Flux<Pagos> findAll() throws Exception;

    Mono<Pagos> findById(Long id) throws Exception;

    Mono<Pagos> save(Pagos pagos) throws Exception;

    Mono<Pagos> update(Long id, Pagos pagos) throws Exception;

    Mono<Void> delete(Long id) throws Exception;
}
