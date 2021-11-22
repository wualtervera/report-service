package com.nttdata.pagos.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pagos {

    private Long id;
    private Double input;
    private Double outputs;
    private String concept;
    private Long idCredit;
    private String datetime;

}
