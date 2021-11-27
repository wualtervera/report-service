package com.nttdata.reportservice.application.operations;

import com.nttdata.reportservice.domain.Report;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReportOperations {

    Flux<Report> findAll();

    Mono<Report> findById(String id);

    Mono<Report> save(Report report);

    Mono<Report> update(String id, Report report);

    Mono<Void> delete(String id);

}
