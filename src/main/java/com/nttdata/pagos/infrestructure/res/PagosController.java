package com.nttdata.pagos.infrestructure.res;


import com.nttdata.pagos.application.domain.Pagos;
import com.nttdata.pagos.application.operations.CustomerCreditOperations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/customerCredit")
@RequiredArgsConstructor
public class CustomerCreditController   {


    private static final Logger logger = LoggerFactory.getLogger(CustomerCreditController.class);
    private final CustomerCreditOperations customerCreditOperations;


    @GetMapping("list")
    public Flux<Pagos> getall() throws Exception{
        try {
            return customerCreditOperations.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Mono<Pagos> getOne(@PathVariable Long id) throws Exception {
        try {
            return customerCreditOperations.findById(id);
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping("add")
    public Mono<Pagos> save(@RequestBody Pagos account) throws Exception {
        try {
            return customerCreditOperations.save(account);
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/{id}")
    public Mono<Pagos> update(@PathVariable Long id, @RequestBody Pagos account) throws Exception {
        try {
            return customerCreditOperations.update(id , account);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) throws Exception {
        try {
            return customerCreditOperations.delete(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
