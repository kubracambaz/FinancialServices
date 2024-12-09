package com.financial.account.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TransactionResponseDto {
    private Long id;

    private LocalDate transactionDate;

    private BigDecimal amount;

    private String transactionType;

    private String description;

}
