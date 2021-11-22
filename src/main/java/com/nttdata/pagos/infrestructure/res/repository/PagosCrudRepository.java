package com.nttdata.pagos.infrestructure.res.repository;


import com.nttdata.pagos.infrestructure.model.dao.PagosDAO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosCrudRepository extends ReactiveCrudRepository<PagosDAO, Long> {


}
