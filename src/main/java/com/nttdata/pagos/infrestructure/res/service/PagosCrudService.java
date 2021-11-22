package com.nttdata.pagos.infrestructure.res.service;

import com.nttdata.pagos.domain.Pagos;
import com.nttdata.pagos.infrestructure.client.service.CreditService;
import com.nttdata.pagos.infrestructure.model.dao.PagosDAO;
import com.nttdata.pagos.application.model.PagosRepository;
import com.nttdata.pagos.infrestructure.res.repository.PagosCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class PagosCrudService implements PagosRepository {
    @Autowired
    private PagosCrudRepository pagosCrudRepository;

    /*@Autowired
    private CreditService creditService;*/

    @Override
    public Flux<Pagos> findAll() {
        log.info("Consulta de Customer credit-SERVICE");
        return pagosCrudRepository.findAll().map(pagosDAO -> getCustomerCredit(pagosDAO));
    }

    @Override
    public Mono<Pagos> findById(Long id) {
        return pagosCrudRepository.findById(id).map(pagosDAO -> getCustomerCredit(pagosDAO));
    }

    @Override
    public Mono<Pagos> save(Pagos pagos) {

        return pagosCrudRepository.save(getCustomerCreditDao(pagos)).map(this::getCustomerCredit);

    }

    @Override
    public Mono<Pagos> update(Long id, Pagos pagos) {

        return pagosCrudRepository.save(getCustomerCreditDao(pagos)).map(this::getCustomerCredit);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return pagosCrudRepository.deleteById(id);
    }



    public Pagos getCustomerCredit(PagosDAO pagosDAO){
        Pagos pagos = new Pagos();
        pagos.setId(pagosDAO.getId());
        pagos.setInput(pagosDAO.getInput());
        pagos.setOutputs(pagosDAO.getOutputs());
        pagos.setConcept(pagosDAO.getConcept());
        pagos.setIdCredit(pagosDAO.getIdCredit());
        pagos.setDatetime(pagosDAO.getDatetime());
        return pagos;
    }


    public PagosDAO getCustomerCreditDao(Pagos pagos){
        PagosDAO pagosDAO = new PagosDAO();
        pagosDAO.setId(pagos.getId());
        pagosDAO.setInput(pagos.getInput());
        pagosDAO.setOutputs(pagos.getOutputs());
        pagosDAO.setConcept(pagos.getConcept());
        pagosDAO.setIdCredit(pagos.getIdCredit());
        pagosDAO.setDatetime(pagos.getDatetime());
        return pagosDAO;
    }
}
