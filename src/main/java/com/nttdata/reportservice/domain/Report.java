package com.nttdata.reportservice.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Report {
    private String id;
    private Double dailyAmount; //Reporte total de trnsferencias
    private Double commission; //Comision por trnsaferencias
    private LocalDate date;
    private String idTransfer;

}
