package com.financial.account.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TransactionResponse {
    private Long id;

    private LocalDate transactionDate;

    private BigDecimal amount;

    private String transactionType;

    private String description;

}
