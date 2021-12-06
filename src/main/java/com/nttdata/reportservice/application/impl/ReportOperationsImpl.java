package com.nttdata.reportservice.application.impl;

import com.nttdata.reportservice.domain.Report;
import com.nttdata.reportservice.application.model.ReportRepository;
import com.nttdata.reportservice.application.operations.ReportOperations;
import com.nttdata.reportservice.infrestructure.model.dto.AverageBalanceDto;
import com.nttdata.reportservice.infrestructure.model.dto.CommissionProductDto;
import com.nttdata.reportservice.infrestructure.model.dto.CommissionSearchDto;
import com.nttdata.reportservice.infrestructure.model.dto.ConsolidatedReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ReportOperationsImpl implements ReportOperations {


    private final ReportRepository reportRepository;

    @Override
    public Flux<Report> findAll() {
            return reportRepository.findAll();
    }

    @Override
    public Mono<Report> findById(String id) {
            return reportRepository.findById(id);
    }

    @Override
    public Mono<Report> save(Report report) {
            return reportRepository.save(report);
    }

    @Override
    public Mono<Report> update(String id, Report report) {
            return reportRepository.update(id, report);
    }

    @Override
    public Mono<Void> delete(String id){
            return reportRepository.delete(id);
    }

    @Override
    public Mono<Report> saveAverageBalance(String idCustomer) {
        return reportRepository.saveAverageBalance(idCustomer);
    }

    @Override
    public Mono<AverageBalanceDto> getAverageBalance(String idCustomer) {
        return reportRepository.getAverageBalance(idCustomer);
    }

    @Override
    public Mono<CommissionProductDto> getCommissionProduct(CommissionSearchDto commissionSearchDto) {
        return reportRepository.getCommissionProduct(commissionSearchDto);
    }

    @Override
    public Mono<ConsolidatedReportDto> getConsolidated(String idCustomer) {
        return reportRepository.getConsolidated(idCustomer);
    }

}
