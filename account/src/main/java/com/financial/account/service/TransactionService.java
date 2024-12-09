package com.financial.account.service;

import com.financial.account.domain.dto.AccountRequestDto;
import com.financial.account.domain.dto.AccountResponseDto;
import com.financial.account.domain.dto.TransactionRequestDto;
import com.financial.account.domain.dto.TransactionResponseDto;
import com.financial.account.domain.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {
    TransactionResponseDto createTransaction(TransactionRequestDto requestDto);
    List<TransactionEntity> getTransactions(Long accountId);
}
