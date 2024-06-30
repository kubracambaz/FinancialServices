package com.financial.account.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<AccountEntity> accounts = new ArrayList<>();

}
