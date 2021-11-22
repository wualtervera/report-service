package com.nttdata.pagos.application.impl;

import com.nttdata.pagos.domain.Pagos;
import com.nttdata.pagos.application.model.PagosRepository;
import com.nttdata.pagos.application.operations.PagosOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class PagosImpl implements PagosOperations {


    private final PagosRepository pagosRepository;

    @Override
    public Flux<Pagos> findAll() throws Exception {
        try {
            return pagosRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Pagos> findById(Long id) throws Exception {
        try {
            return pagosRepository.findById(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Pagos> save(Pagos pagos) throws Exception {
        try {
            return pagosRepository.save(pagos);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Pagos> update(Long id, Pagos pagos) throws Exception {
        try {
            return pagosRepository.update(id, pagos);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Void> delete(Long id) throws Exception {
        try {
            return pagosRepository.delete(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
