package com.nttdata.pagos.infrestructure.service;

import com.nttdata.pagos.application.domain.Pagos;
import com.nttdata.pagos.infrestructure.model.dao.PagosDAO;
import com.nttdata.pagos.infrestructure.repository.CustomerCreditCrudRepository;
import com.nttdata.pagos.model.CustomerCreditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Slf4j
@Component
public class CustomerCreditCrudService implements CustomerCreditRepository {


    @Autowired
    private CustomerCreditCrudRepository customerCreditCrudRepository;

    @Override
    public Flux<Pagos> findAll() {
        log.info("Consulta de Customer credit-SERVICE");
        return customerCreditCrudRepository.findAll().map(pagosDAO -> getCustomerCredit(pagosDAO));
    }

    @Override
    public Mono<Pagos> findById(Long id) {
        return customerCreditCrudRepository.findById(id).map(pagosDAO -> getCustomerCredit(pagosDAO));
    }

    @Override
    public Mono<Pagos> save(Pagos pagos) {
        return customerCreditCrudRepository.save(getCustomerCreditDao(pagos)).map(this::getCustomerCredit);
    }

    @Override
    public Mono<Pagos> update(Long id, Pagos pagos) {
        return customerCreditCrudRepository.save(getCustomerCreditDao(pagos)).map(this::getCustomerCredit);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return customerCreditCrudRepository.deleteById(id);
    }

    public Pagos getCustomerCredit(PagosDAO pagosDAO){
        Pagos pagos = new Pagos();
        pagos.setId(pagosDAO.getId());
        pagos.setIdCredit(pagosDAO.getIdCredit());
        pagos.setIdCustomer(pagosDAO.getIdCustomer());
        pagos.setDatetime(LocalDateTime.now().toLocalDate());
        return pagos;
    }


    public PagosDAO getCustomerCreditDao(Pagos pagos){
        PagosDAO pagosDAO = new PagosDAO();
        pagosDAO.setId(pagos.getId());
        pagosDAO.setIdCredit(pagos.getIdCredit());
        pagosDAO.setIdCustomer(pagos.getIdCustomer());
        pagosDAO.setDatetime(LocalDateTime.now().toLocalDate());
        return pagosDAO;
    }
}
