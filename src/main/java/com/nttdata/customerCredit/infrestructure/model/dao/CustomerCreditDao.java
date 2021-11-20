package com.nttdata.customerCredit.infrestructure.model.dao;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("customerCredit")
@NoArgsConstructor
public class CustomerCreditDao {

    @Id
    private Long id;
    private Long idCredit;
    private Long idCustomer;
    private LocalDate datetime;
}
