package com.financial.account.domain.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private Long customerId;

    @Min(value = 0, message = "Amount shouldn't be less than zero")
    private BigDecimal initialCredit;
}
