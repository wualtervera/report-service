package com.nttdata.reportservice.infrestructure.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDto {

    private String id;

    private String codeCredit; //Código del credito

    private Double amount; //Moto total del crédito asignado

    private Double balance; //Saldo

    private Double limit; //Límite de transacciones

    private Double paymentMonth; //Pago del mes

    private String coin; // SOLES, DOLARES

    private int mouthsCredit; //Cantidad de meses para pagar el crédito

    private LocalDate startDate; //Fecha de inicio del crédito

    private LocalDate paymentDate; // Fecha de pago del crédito

    private LocalDate exipirationDate; //Fecha fin del crédito

    private String idCustomer; //Realación hacia Customers

    private LocalDate date;

}
