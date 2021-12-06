package com.nttdata.reportservice.infrestructure.res.controller;


import com.nttdata.reportservice.domain.Report;
import com.nttdata.reportservice.application.operations.ReportOperations;
import com.nttdata.reportservice.infrestructure.model.dto.AverageBalanceDto;
import com.nttdata.reportservice.infrestructure.model.dto.CommissionProductDto;
import com.nttdata.reportservice.infrestructure.model.dto.CommissionSearchDto;
import com.nttdata.reportservice.infrestructure.model.dto.CreditDto;
import com.nttdata.reportservice.infrestructure.res.service.WebClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportOperations reportOperations;

    @Autowired
    private WebClientService webClientService;

    @GetMapping("")
    public Flux<Report> getall(){
            return reportOperations.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Report> getOne(@PathVariable String id) throws Exception {
            return reportOperations.findById(id);
    }

    @PostMapping("")
    public Mono<Report> save(@RequestBody Report account){
            return reportOperations.save(account);
    }

    @PutMapping("/{id}")
    public Mono<Report> update(@PathVariable String id, @RequestBody Report account){
            return reportOperations.update(id , account);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
            return reportOperations.delete(id);
    }

    //Otro
    @GetMapping("credits/{idCustomer}")
    public Flux<CreditDto> getRepo(@PathVariable String idCustomer){
        log.info("Entre a GER REPOS - CREDITS");
        return webClientService.getCredits(idCustomer);
    }

    //REPORTES

    //Guardar saldo promedio diario en base de datos - guarda el reporte
    @PostMapping("saveAverageBalance/{idCustomer}")
    public Mono<Report> saveSaldoProm(@PathVariable String idCustomer){
        return reportOperations.saveAverageBalance(idCustomer);
    }

    //Calcular y obtener saldo promedio diario - no garda el reporte
    @GetMapping("getAverageBalance/{idCustomer}")
    public Mono<AverageBalanceDto> getSaldoProm(@PathVariable String idCustomer){
        return reportOperations.getAverageBalance(idCustomer);
    }

    //Reporte de comisiones cobradas por las transacciones realizadas por cada producto en unrango de fecha
    @PostMapping("getCommission")
    public Mono<CommissionProductDto> getCommission(@RequestBody CommissionSearchDto commissionSearchDto){
        return reportOperations.getCommissionProduct(commissionSearchDto);
    }


}
