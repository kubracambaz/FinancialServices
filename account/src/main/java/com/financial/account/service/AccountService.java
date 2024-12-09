package com.financial.account.service;

import com.financial.account.domain.dto.AccountRequestDto;
import com.financial.account.domain.dto.AccountResponseDto;

public interface AccountService {
    AccountResponseDto createAccount(AccountRequestDto requestDto);
}
