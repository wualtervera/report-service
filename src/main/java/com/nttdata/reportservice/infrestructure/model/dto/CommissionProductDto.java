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
public class CommissionProductDto {
    private String idProduct;
    //private String idCustomer;
    //private String nameCustomer;
    private double commissionProduct;
    private LocalDate date;
}
