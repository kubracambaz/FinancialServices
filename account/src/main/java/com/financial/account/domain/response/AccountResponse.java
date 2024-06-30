package com.financial.account.domain.response;

import com.financial.account.domain.entity.TransactionEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AccountResponse {
    private Integer id;

    private BigDecimal balance;

    private LocalDate creationDate;
   // private List<TransactionEntity> transactions;
}
