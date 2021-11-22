package com.nttdata.pagos.infrestructure.model.dao;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("customerCredit")
@NoArgsConstructor
public class PagosDAO {

    @Id
    private Long id;
    private Double input;
    private Double outputs;
    private String concept;
    private Long idCredit;
    private String datetime;
}
