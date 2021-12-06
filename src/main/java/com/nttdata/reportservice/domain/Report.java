package com.nttdata.reportservice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {
    private String id;
    private String idCustomer;
    private String nameCustomer;
    private double saldoDiarioMensual;
    private LocalDate date;

}
