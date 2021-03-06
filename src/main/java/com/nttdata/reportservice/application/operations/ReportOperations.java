package com.nttdata.reportservice.application.operations;

import com.nttdata.reportservice.domain.Report;
import com.nttdata.reportservice.infrestructure.model.dto.AverageBalanceDto;
import com.nttdata.reportservice.infrestructure.model.dto.CommissionProductDto;
import com.nttdata.reportservice.infrestructure.model.dto.CommissionSearchDto;
import com.nttdata.reportservice.infrestructure.model.dto.ConsolidatedReportDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReportOperations {

    Flux<Report> findAll();

    Mono<Report> findById(String id);

    Mono<Report> save(Report report);

    Mono<Report> update(String id, Report report);

    Mono<Void> delete(String id);

    Mono<Report> saveAverageBalance(String idCustomer);

    Mono<AverageBalanceDto> getAverageBalance(String idCustomer);

    Mono<CommissionProductDto> getCommissionProduct(CommissionSearchDto commissionSearchDto);

    Mono<ConsolidatedReportDto> getConsolidated(String idCustomer);

}
