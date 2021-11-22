package com.nttdata.pagos.application.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pagos {

    private Long id;
    private Double input;
    private Double outputs;
    private String concept;
    private String datetime;

}
