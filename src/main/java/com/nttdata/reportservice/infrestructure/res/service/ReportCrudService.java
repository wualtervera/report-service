package com.nttdata.reportservice.infrestructure.res.service;

import com.nttdata.reportservice.domain.Report;
import com.nttdata.reportservice.infrestructure.model.dao.ReportDao;
import com.nttdata.reportservice.application.model.ReportRepository;
import com.nttdata.reportservice.infrestructure.model.dto.*;
import com.nttdata.reportservice.infrestructure.res.repository.ReportCrudRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ReportCrudService implements ReportRepository {
    @Autowired
    private ReportCrudRepository reportCrudRepository;

    @Autowired
    private WebClientService webClientService;

    @Override
    public Flux<Report> findAll() {
        log.info("Consulta de Customer credit-SERVICE");
        return reportCrudRepository.findAll().map(this::toReport);
    }

    @Override
    public Mono<Report> findById(String id) {
        return reportCrudRepository.findById(id).map(this::toReport);
    }

    //Utilizar saveAverageBalance() en remplazoa de este método
    @Override
    public Mono<Report> save(Report report) {
        log.info("En save");
        return reportCrudRepository.save(toReportDao(report)).map(this::toReport);
    }

    @Override
    public Mono<Report> update(String id, Report report) {
        return reportCrudRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Error: NO exite el reporte")))
                .flatMap(reportDao -> {
                    reportDao = this.toReportDao(report);
                    return reportCrudRepository.save(reportDao).map(this::toReport);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return reportCrudRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Error: NO exite el reporte para eliminar.")))
                .flatMap(reportDao -> {
                    reportDao.setId(id);
                    return reportCrudRepository.deleteById(reportDao.getId());
                });

    }

    //Metod guarda y deuelve el reporte de saldo promdio diario emnsual
    @Override
    public Mono<Report> saveAverageBalance(String idCustomer) {
        log.info("Entre a getReportSaldoProm - EN SERVICE");

        return webClientService.getCreditsIdCustomer(idCustomer)
                .collect(Collectors.summingDouble(CreditDto::getBalance))
                .flatMap(saldo ->
                        webClientService.getCustomer(idCustomer)
                                .flatMap(customerDto -> {
                                    double saldoPromedioMes = (saldo * 30) / 30;

                                    //Reporte guardado en base de datos
                                    return reportCrudRepository.save(
                                            ReportDao.builder()
                                                    .idCustomer(idCustomer)
                                                    .nameCustomer(customerDto.getName().concat(" " + customerDto.getSurname()))
                                                    .saldoDiarioMensual(saldoPromedioMes)
                                                    .date(LocalDateTime.now().toLocalDate()).build()
                                    ).map(reportDao -> toReport(reportDao)
                                    );
                                })
                );

    }

    //Devuelve cálculo de saldo promedio diario mensual - no guarda en db
    @Override
    public Mono<AverageBalanceDto> getAverageBalance(String idCustomer) {
        return webClientService.getCreditsIdCustomer(idCustomer)
                .collect(Collectors.summingDouble(CreditDto::getBalance))
                .flatMap(saldo ->
                        webClientService.getCustomer(idCustomer)
                                .flatMap(customerDto -> {
                                    double saldoPromedioMes = (saldo * 30) / 30;

                                    return Mono.just(AverageBalanceDto.builder()
                                            .idCustomer(idCustomer)
                                            .nameCustomer(customerDto.getName())
                                            .saldoDiarioMensual(saldoPromedioMes)
                                            .date(LocalDateTime.now().toLocalDate()).build());
                                })
                );

    }

    //Reporte de comisiones cobradas por las transacciones realizadas por cada producto en unrango de fecha
    @Override
    public Mono<CommissionProductDto> getCommissionProduct(CommissionSearchDto cp) {
        return webClientService.getTransactionProduct(cp.getIdProduct())
                .filter(t -> t.getDate().isAfter(cp.getStartDate().minusDays(1)) && t.getDate().isBefore(cp.getEndDate().plusDays(1)))
                .collect(Collectors.summingDouble(TransactionsDto::getCommissionTransaction))
                .flatMap(commission ->
                        Mono.just(CommissionProductDto.builder()
                                .idProduct(cp.getIdProduct())
                                //.commissionProduct(commission)
                                .commissionProduct(Double.parseDouble(new DecimalFormat("####.00").format(commission)))
                                .date(LocalDateTime.now().toLocalDate()).build())
                );
    }

    //Reporte consolidado de productos de un cliente
    @Override
    public Mono<ConsolidatedReportDto> getConsolidated(String idCustomer) {
        return webClientService.getCustomer(idCustomer)
                .flatMap(c ->
                        webClientService.getCreditsIdCustomer(c.getId()).collectList()
                                .flatMap(listC ->
                                        webClientService.getAccountsIdCustomer(c.getId()).collectList()
                                                .flatMap(listA ->
                                                        Mono.just(ConsolidatedReportDto.builder()
                                                                .idCustomer(idCustomer)
                                                                .dni(c.getDni())
                                                                .nameCustomer(c.getName().concat(" " + c.getSurname()))
                                                                .credit(listC)
                                                                .account(listA)
                                                                .date(LocalDateTime.now().toLocalDate()).build())
                                                )
                                )
                );

    }


    //Mapper
    public Report toReport(ReportDao reportDao) {
        Report report = new Report();
        report.setId(reportDao.getId());
        report.setIdCustomer(reportDao.getIdCustomer());
        report.setNameCustomer(reportDao.getNameCustomer());
        report.setSaldoDiarioMensual(reportDao.getSaldoDiarioMensual());
        report.setDate(reportDao.getDate());
        return report;
    }


    public ReportDao toReportDao(Report report) {
        ReportDao reportDao = new ReportDao();
        reportDao.setId(report.getId());
        reportDao.setIdCustomer(report.getIdCustomer());
        reportDao.setNameCustomer(report.getNameCustomer());
        reportDao.setSaldoDiarioMensual(report.getSaldoDiarioMensual());
        reportDao.setDate(report.getDate());
        return reportDao;
    }
}
