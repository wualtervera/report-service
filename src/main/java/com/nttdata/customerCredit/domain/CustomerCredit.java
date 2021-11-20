package com.nttdata.customerCredit.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerCredit {

    private Long id;
    private Long idCredit;
    private Long idCustomer;
    private LocalDate datetime;
}
