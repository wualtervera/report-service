package com.nttdata.customerCredit.infrestructure.service;

import com.nttdata.customerCredit.domain.CustomerCredit;
import com.nttdata.customerCredit.infrestructure.model.dao.CustomerCreditDao;
import com.nttdata.customerCredit.infrestructure.repository.CustomerCreditCrudRepository;
import com.nttdata.customerCredit.model.CustomerCreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;


@Component
public class CustomerCreditCrudService implements CustomerCreditRepository {


    @Autowired
    private CustomerCreditCrudRepository customerCreditCrudRepository;

    @Override
    public Flux<CustomerCredit> findAll() {
        return customerCreditCrudRepository.findAll().map(customerCreditDao -> getCustomerCredit(customerCreditDao));
    }

    @Override
    public Mono<CustomerCredit> findById(Long id) {
        return customerCreditCrudRepository.findById(id).map(customerCreditDao -> getCustomerCredit(customerCreditDao));
    }

    @Override
    public Mono<CustomerCredit> save(CustomerCredit customerCredit) {
        return customerCreditCrudRepository.save(getCustomerCreditDao(customerCredit)).map(this::getCustomerCredit);
    }

    @Override
    public Mono<CustomerCredit> update(Long id, CustomerCredit customerCredit) {
        return customerCreditCrudRepository.save(getCustomerCreditDao(customerCredit)).map(this::getCustomerCredit);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return customerCreditCrudRepository.deleteById(id);
    }

    public CustomerCredit getCustomerCredit(CustomerCreditDao customerCreditDao){
        CustomerCredit customerCredit = new CustomerCredit();
        customerCredit.setId(customerCreditDao.getId());
        customerCredit.setIdCredit(customerCreditDao.getIdCredit());
        customerCredit.setIdCustomer(customerCreditDao.getIdCustomer());
        customerCredit.setDatetime(LocalDateTime.now().toLocalDate());
        return customerCredit;
    }


    public CustomerCreditDao getCustomerCreditDao(CustomerCredit customerCredit){
        CustomerCreditDao customerCreditDao = new CustomerCreditDao();
        customerCreditDao.setId(customerCredit.getId());
        customerCreditDao.setIdCredit(customerCredit.getIdCredit());
        customerCreditDao.setIdCustomer(customerCredit.getIdCustomer());
        customerCreditDao.setDatetime(LocalDateTime.now().toLocalDate());
        return customerCreditDao;
    }
}
