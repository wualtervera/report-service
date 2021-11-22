package com.nttdata.pagos.infrestructure.model.dto;

import lombok.Data;

@Data
public class PagoDTO {
    private Long id;
    private Double input;
    private String concept;
    private Long idCredit;
    private String datetime;
}
