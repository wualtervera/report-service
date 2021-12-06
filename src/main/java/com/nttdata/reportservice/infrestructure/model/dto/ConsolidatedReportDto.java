package com.nttdata.reportservice.infrestructure.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsolidatedReportDto {
    private String idCustomer;
    private String dni;
    private String ruc;
    private String nameCustomer;
    private List<AccountDto> account;
    private List<CreditDto> credit;
    private LocalDate date;
}
