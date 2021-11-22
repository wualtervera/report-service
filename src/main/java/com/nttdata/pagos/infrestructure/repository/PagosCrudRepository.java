package com.nttdata.pagos.infrestructure.repository;


import com.nttdata.pagos.infrestructure.model.dao.PagosDAO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCreditCrudRepository extends ReactiveCrudRepository<PagosDAO, Long> {
}
