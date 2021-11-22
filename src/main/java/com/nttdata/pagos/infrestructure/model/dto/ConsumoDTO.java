package com.nttdata.pagos.infrestructure.model.dto;

import lombok.Data;

@Data
public class ConsumoDTO {
    private Long id;
    private Double outputs;
    private String concept;
    private Long idCredit;
    private String datetime;

}
