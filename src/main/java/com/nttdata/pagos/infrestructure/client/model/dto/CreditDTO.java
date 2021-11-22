package com.nttdata.pagos.infrestructure.client.model.dto;

import lombok.Data;

@Data
public class CreditDTO {
    private Long id;

    private Double balance;

    private Double payment_month;

    private String date;
}
