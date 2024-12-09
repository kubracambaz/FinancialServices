package com.financial.account.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AccountResponse {
    private Integer id;

    private BigDecimal balance;

    private LocalDate creationDate;
}
