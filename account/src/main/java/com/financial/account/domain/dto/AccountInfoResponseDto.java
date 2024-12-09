package com.financial.account.domain.dto;

import com.financial.account.domain.entity.TransactionEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AccountInfoResponseDto {
    private Long id;

    private BigDecimal balance;

    private LocalDate creationDate;

    private List<TransactionResponseDto> transactions;
}
