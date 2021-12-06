package com.nttdata.reportservice.infrestructure.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionsDto {

    private String id;
    private double input; //Entrada de dinero
    private double ouput; //Salida de dinero
    private String idProduct;
    private String typeTran;   //Tipo de trnsacción (CREDITO, CUENTA BANCARIA, TARJETA DECREDITO)
    private double commissionTransaction; //Comisión de mantenimiento por producto
    private LocalDate date;
}
