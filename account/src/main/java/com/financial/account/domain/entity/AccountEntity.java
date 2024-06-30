package com.financial.account.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Account")
public class AccountEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CustomerEntity customer;

    private BigDecimal balance;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    private Boolean isActive;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<TransactionEntity> transactions = new ArrayList<>();
}
