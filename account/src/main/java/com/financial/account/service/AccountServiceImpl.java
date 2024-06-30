package com.financial.account.service;

import com.financial.account.domain.dto.*;
import com.financial.account.domain.entity.AccountEntity;
import com.financial.account.domain.entity.CustomerEntity;
import com.financial.account.domain.entity.TransactionEntity;
import com.financial.account.repository.AccountRepository;
import com.financial.account.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionService transactionService;

    @Override
    public AccountResponseDto createAccount(AccountRequestDto requestDto) {

        AccountEntity accountEntity = AccountEntity.builder()
                .balance(requestDto.getInitialCredit())
                .customer(customerRepository.getReferenceById(requestDto.getCustomerId()))
                .creationDate(LocalDate.now())
                .isActive(true)
                .build();
        accountRepository.save(accountEntity);

        if(requestDto.getInitialCredit().compareTo(ZERO)>0){
            TransactionRequestDto transaction = new TransactionRequestDto(
                    accountEntity.getId(),
                    LocalDate.now(),
                    requestDto.getInitialCredit(),
                    "D",
                    "initial credit");
            transactionService.createTransaction(transaction);
        }

        return modelMapper.map(accountEntity, AccountResponseDto.class);

    }

    @Override
    public AccountInfoResponseDto getAccount(Long accountId) {

        AccountInfoResponseDto accountInfoResponseDto = new AccountInfoResponseDto();
        AccountEntity account = accountRepository.getReferenceById(accountId);

        List<TransactionEntity> transactionList = transactionService.getTransactions(accountId);
        List<TransactionResponseDto> transactions = new ArrayList<>();
        transactionList.forEach(transaction -> {
            TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
            transactionResponseDto.setId(transaction.getId());
            transactionResponseDto.setTransactionDate(transaction.getTransactionDate());
            transactionResponseDto.setAmount(transaction.getAmount());
            transactionResponseDto.setTransactionType(transaction.getTransactionType());
            transactionResponseDto.setDescription(transaction.getDescription());
            transactions.add(transactionResponseDto);
        });

        accountInfoResponseDto.setId(account.getId());
        accountInfoResponseDto.setBalance(account.getBalance());
        accountInfoResponseDto.setCreationDate(account.getCreationDate());
        accountInfoResponseDto.setTransactions(transactions);

        return accountInfoResponseDto;
    }

}
