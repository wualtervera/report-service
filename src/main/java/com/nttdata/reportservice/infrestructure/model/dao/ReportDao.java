package com.nttdata.reportservice.infrestructure.model.dao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("report")
public class ReportDao {
    @Id
    private String id;
    private String idCustomer;
    private String nameCustomer;
    private double saldoDiarioMensual;
    private LocalDate date;
}
