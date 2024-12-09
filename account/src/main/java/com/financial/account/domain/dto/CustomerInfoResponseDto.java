package com.financial.account.domain.dto;

import com.financial.account.domain.response.AccountResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ListIterator;

@Getter
@Setter
public class CustomerInfoResponseDto {
    private String name;
    private String surName;
    private List<AccountInfoResponseDto> accounts;
}
