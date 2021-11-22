package com.nttdata.pagos.infrestructure.client;

import com.nttdata.pagos.infrestructure.client.model.Credit;
import com.nttdata.pagos.infrestructure.client.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    //Controllador resta para realizar pedicions de prueba

    @GetMapping("read/{idCredit}")
    public Mono<Credit> getOne(@PathVariable Long idCredit) throws Exception {
        try {
            return creditService.findIdCredit(idCredit);
        }catch (Exception e){
            throw e;
        }
    }


    @PutMapping("updatePayment/{id}")
    public Mono<Credit> updatePayment(@PathVariable Long id, @RequestBody Credit credit) throws Exception {
        try {
            return creditService.payment(credit, id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("updateExpense/{id}")
    public Mono<Credit> updateExpense(@PathVariable Long id, @RequestBody Credit credit) throws Exception {
        try {
            return creditService.expense(credit, id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
