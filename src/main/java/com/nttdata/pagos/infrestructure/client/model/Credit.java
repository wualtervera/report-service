package com.nttdata.pagos.infrestructure.client.model;

import lombok.Data;

@Data
public class Credit {
    private Long id;

    private Long code;

    private String type_credit;

    private Double credit;

    private Double balance;

    private Double limit;

    private int mouths_credit;

    private Double payment_month;

    private String coin;

    private String start_date;

    private String payment_date;

    private String exipiration_date;

    private Long idCustomer;

    private String date;

}
