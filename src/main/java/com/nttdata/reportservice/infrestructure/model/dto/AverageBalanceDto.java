package com.nttdata.reportservice.infrestructure.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AverageBalanceDto {
    private String idCustomer;
    private String nameCustomer;
    private double saldoDiarioMensual;
    private LocalDate date;
}
