package com.nttdata.reportservice.infrestructure.res.controller;


import com.nttdata.reportservice.domain.Report;
import com.nttdata.reportservice.application.operations.ReportOperations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportOperations reportOperations;


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

}
