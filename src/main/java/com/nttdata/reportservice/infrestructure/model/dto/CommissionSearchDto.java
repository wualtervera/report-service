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
public class CommissionSearchDto {
    private String idProduct;
    private LocalDate startDate;
    private LocalDate endDate;
}
