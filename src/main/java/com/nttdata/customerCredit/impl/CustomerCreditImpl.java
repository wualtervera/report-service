package com.nttdata.customerCredit.impl;

import com.nttdata.customerCredit.domain.CustomerCredit;
import com.nttdata.customerCredit.model.CustomerCreditRepository;
import com.nttdata.customerCredit.operations.CustomerCreditOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class CustomerCreditImpl implements CustomerCreditOperations {


    private final CustomerCreditRepository customerCreditRepository;

    @Override
    public Flux<CustomerCredit> findAll() throws Exception {
        try {
            return customerCreditRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<CustomerCredit> findById(Long id) throws Exception {
        try {
            return customerCreditRepository.findById(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<CustomerCredit> save(CustomerCredit customerCredit) throws Exception {
        try {
            return customerCreditRepository.save(customerCredit);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<CustomerCredit> update(Long id, CustomerCredit customerCredit) throws Exception {
        try {
            return customerCreditRepository.update(id, customerCredit);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mono<Void> delete(Long id) throws Exception {
        try {
            return customerCreditRepository.delete(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
