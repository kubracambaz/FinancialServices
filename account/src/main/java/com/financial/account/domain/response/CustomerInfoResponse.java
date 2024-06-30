package com.financial.account.domain.response;

import com.financial.account.domain.dto.AccountResponseDto;
import com.financial.account.domain.dto.TransactionResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerInfoResponse {
    private String name;
    private String surName;
    private List<AccountResponse> accounts;
}
