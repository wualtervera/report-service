package com.nttdata.reportservice.infrestructure.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String id;

    private String dni;

    private String ruc;

    private String name;

    private String surname;

    private String telephone;

    private String direction;

    private String email;

    private String password;

    private String role; // PROPIETARIO, APODERADO

    private LocalDate date;
}
