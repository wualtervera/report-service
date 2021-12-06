package com.nttdata.reportservice.infrestructure.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AccountDto {

    private String id;
    private double balance;     //Cuanto dinero tiene
    private String typeAccount;  // Tipo de cuenta (Corriente, ahorro y plazo fijo)
    private String typeCard;
    private String numberCard;
    private String ccv;
    private  double minAmount; //Monto mínimo cada mes para personas vip
    private  double maxTransac; //Máximo de trnsacciones
    private int maxLimitMov;  //Límite máximo de movimientos
    private String coin;      // Tipo de moneda
    private String idcustomer; //Client
    private double maintenance; //Comisión de mantenimiento
    private LocalDate date;     //Fecha de creacion

}
