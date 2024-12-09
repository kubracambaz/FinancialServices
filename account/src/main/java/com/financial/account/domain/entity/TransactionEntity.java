package com.financial.account.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate transactionDate;

    private BigDecimal amount;

    private String transactionType;

    private String description;

    @ManyToOne
    private AccountEntity account;
}
