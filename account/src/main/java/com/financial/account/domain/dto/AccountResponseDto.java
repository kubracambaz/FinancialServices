package com.financial.account.domain.dto;

import com.financial.account.domain.entity.CustomerEntity;
import com.financial.account.domain.entity.TransactionEntity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AccountResponseDto {
    private Integer id;

    private BigDecimal balance;

    private LocalDate creationDate;

   // private List<TransactionEntity> transactions;
}
