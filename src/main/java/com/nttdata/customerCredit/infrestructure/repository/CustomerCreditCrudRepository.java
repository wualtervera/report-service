package com.nttdata.customerCredit.infrestructure.repository;


import com.nttdata.customerCredit.infrestructure.model.dao.CustomerCreditDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCreditCrudRepository extends ReactiveCrudRepository<CustomerCreditDao, Long> {
}
