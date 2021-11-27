package com.nttdata.reportservice.infrestructure.model.dao;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("report")
@NoArgsConstructor
public class ReportDao {
    @Id
    private String id;
    private Double dailyAmount; //Reporte total de trnsferencias
    private Double commission; //Comision por trnsaferencias
    private LocalDate date;
    private String idTransfer;
}
