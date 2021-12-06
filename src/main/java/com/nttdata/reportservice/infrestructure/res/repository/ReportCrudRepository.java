package com.nttdata.reportservice.infrestructure.res.repository;


import com.nttdata.reportservice.domain.Report;
import com.nttdata.reportservice.infrestructure.model.dao.ReportDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReportCrudRepository extends ReactiveCrudRepository<ReportDao, String> {

}
