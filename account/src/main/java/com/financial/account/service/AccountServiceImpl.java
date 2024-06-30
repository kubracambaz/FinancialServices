package com.financial.account.service;

import com.financial.account.domain.dto.*;
import com.financial.account.domain.entity.AccountEntity;
import com.financial.account.domain.entity.CustomerEntity;
import com.financial.account.domain.entity.TransactionEntity;
import com.financial.account.exceptions.ErrorCode;
import com.financial.account.exceptions.FinancialBusinessException;
import com.financial.account.repository.AccountRepository;
import com.financial.account.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


       Optional<CustomerEntity> customer =   customerRepository.findById(requestDto.getCustomerId());
       if(!customer.isPresent()) { throw new FinancialBusinessException(ErrorCode.NO_CUSTOMER_EXCEPTION);}

        AccountEntity accountEntity = AccountEntity.builder()
                .balance(requestDto.getInitialCredit())
                .customer(customer.get())
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
        }else if(requestDto.getInitialCredit().compareTo(ZERO)<0){
            throw new FinancialBusinessException(ErrorCode.INITIAL_CREDIT_EXCEPTION);
        }

        return modelMapper.map(accountEntity, AccountResponseDto.class);

    }

}
