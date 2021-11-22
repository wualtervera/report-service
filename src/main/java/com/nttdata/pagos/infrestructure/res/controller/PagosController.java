package com.nttdata.pagos.infrestructure.res.controller;


import com.nttdata.pagos.domain.Pagos;
import com.nttdata.pagos.application.operations.PagosOperations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/pagos")
@RequiredArgsConstructor
public class PagosController {


    private static final Logger logger = LoggerFactory.getLogger(PagosController.class);
    private final PagosOperations pagosOperations;


    @GetMapping("read")
    public Flux<Pagos> getall() throws Exception{
        try {
            return pagosOperations.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("read/{id}")
    public Mono<Pagos> getOne(@PathVariable Long id) throws Exception {
        try {
            return pagosOperations.findById(id);
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping("create")
    public Mono<Pagos> save(@RequestBody Pagos account) throws Exception {
        try {
            return pagosOperations.save(account);
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("update/{id}")
    public Mono<Pagos> update(@PathVariable Long id, @RequestBody Pagos account) throws Exception {
        try {
            return pagosOperations.update(id , account);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable Long id) throws Exception {
        try {
            return pagosOperations.delete(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
