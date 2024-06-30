package com.financial.account.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerInfoResponse {
    private String name;
    private String surName;
    private List<AccountInfoResponse> accounts;
}
