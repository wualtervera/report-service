package com.nttdata.reportservice.infrestructure.res.service;

import com.nttdata.reportservice.domain.Report;
import com.nttdata.reportservice.infrestructure.model.dao.ReportDao;
import com.nttdata.reportservice.application.model.ReportRepository;
import com.nttdata.reportservice.infrestructure.res.repository.ReportCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ReportCrudService implements ReportRepository {
    @Autowired
    private ReportCrudRepository reportCrudRepository;

    @Override
    public Flux<Report> findAll() {
        log.info("Consulta de Customer credit-SERVICE");
        return reportCrudRepository.findAll().map(this::toReport);
    }

    @Override
    public Mono<Report> findById(String id) {
        return reportCrudRepository.findById(id).map(this::toReport);
    }

    @Override
    public Mono<Report> save(Report report) {
    log.info("En save");
        return reportCrudRepository.save(toReportDao(report)).map(this::toReport);

    }

    @Override
    public Mono<Report> update(String id, Report report) {

        return reportCrudRepository.findById(id)
                //.switchIfEmpty(Mono.error(new HttpServerErrorException(HttpStatus.NOT_FOUND)))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Error: NO exite el reporte")))
                .flatMap(reportDao -> {
                    reportDao = this.toReportDao(report);
                    return reportCrudRepository.save(reportDao).map(this::toReport);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return reportCrudRepository.findById(id)
                //.switchIfEmpty(Mono.error(new HttpServerErrorException(HttpStatus.NOT_FOUND)))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Error: NO exite el reporte para eliminar.")))
                .flatMap(reportDao -> {
                    reportDao.setId(id);
                    return reportCrudRepository.deleteById(reportDao.getId());
                });

    }



    //Mapper
    public Report toReport(ReportDao reportDao){
        Report report = new Report();
        report.setId(reportDao.getId());
        report.setDailyAmount(reportDao.getDailyAmount());
        report.setCommission(reportDao.getCommission());
        report.setDate(reportDao.getDate());
        report.setIdTransfer(reportDao.getIdTransfer());
        return report;
    }


    public ReportDao toReportDao(Report report){
        ReportDao reportDao = new ReportDao();
        reportDao.setId(report.getId());
        reportDao.setDailyAmount(report.getDailyAmount());
        reportDao.setCommission(report.getCommission());
        reportDao.setDate(report.getDate());
        reportDao.setIdTransfer(report.getIdTransfer());
        return reportDao;
    }
}
