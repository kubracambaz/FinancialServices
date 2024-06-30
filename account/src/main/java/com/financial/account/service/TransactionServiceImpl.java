package com.financial.account.service;

import com.financial.account.domain.dto.TransactionRequestDto;
import com.financial.account.domain.dto.TransactionResponseDto;
import com.financial.account.domain.entity.TransactionEntity;
import com.financial.account.repository.AccountRepository;
import com.financial.account.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionResponseDto createTransaction(TransactionRequestDto requestDto) {

        TransactionEntity transactionEntity = TransactionEntity.builder()
                .transactionType(requestDto.getTransactionType())
                .amount(requestDto.getAmount())
                .transactionDate(requestDto.getTransactionDate())
                .description(requestDto.getDescription())
                .account(accountRepository.getReferenceById(requestDto.getAccountId()))
                .build();

        transactionRepository.save(transactionEntity);
        return modelMapper.map(transactionEntity, TransactionResponseDto.class);

    }

    @Override
    public List<TransactionEntity> getTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
