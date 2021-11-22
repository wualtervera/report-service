package com.nttdata.pagos.application.operations;

import com.nttdata.pagos.domain.Pagos;
import com.nttdata.pagos.infrestructure.model.dto.ConsumoDTO;
import com.nttdata.pagos.infrestructure.model.dto.PagoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PagosOperations {

    Flux<Pagos> findAll() throws Exception;

    Mono<Pagos> findById(Long id) throws Exception;

    Mono<Pagos> save(Pagos pagos) throws Exception;

    Mono<Pagos> update(Long id, Pagos pagos) throws Exception;

    Mono<Void> delete(Long id) throws Exception;

}
