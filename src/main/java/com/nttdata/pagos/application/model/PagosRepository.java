package com.nttdata.pagos.model;

import com.nttdata.pagos.application.domain.Pagos;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerCreditRepository {

    Flux<Pagos> findAll();

    Mono<Pagos> findById(Long id);

    Mono<Pagos> save(Pagos pagos);

    Mono<Pagos> update(Long id, Pagos pagos);

    Mono<Void> delete(Long id);
}
