package com.nttdata.pagos.application.model;

import com.nttdata.pagos.domain.Pagos;
import com.nttdata.pagos.infrestructure.model.dto.ConsumoDTO;
import com.nttdata.pagos.infrestructure.model.dto.PagoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PagosRepository {

    Flux<Pagos> findAll();

    Mono<Pagos> findById(Long id);

    Mono<Pagos> save(Pagos pagos);

    Mono<Pagos> update(Long id, Pagos pagos);

    Mono<Void> delete(Long id);


}
