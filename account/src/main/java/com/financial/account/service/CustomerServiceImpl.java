package com.financial.account.service;

import com.financial.account.domain.dto.*;
import com.financial.account.domain.entity.AccountEntity;
import com.financial.account.domain.entity.CustomerEntity;
import com.financial.account.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountService accountService;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(requestDto.getName())
                .surname(requestDto.getSurname())
                .build();
        customerRepository.save(customerEntity);
        return modelMapper.map(customerEntity, CustomerResponseDto.class);

    }

    @Override
    public CustomerInfoResponseDto getCustomer(Long customerId) {
        CustomerInfoResponseDto customerInfoResponseDto = new CustomerInfoResponseDto();
        List<AccountInfoResponseDto> accountInfoList = new ArrayList<>();

        CustomerEntity customer = customerRepository.getReferenceById(customerId);

        customerInfoResponseDto.setName(customer.getName());
        customerInfoResponseDto.setSurName(customer.getSurname());

        List<AccountEntity> accounts = customer.getAccounts();

        accounts.forEach(account -> {
            AccountInfoResponseDto accountInfoResponseDto = modelMapper.map(account,AccountInfoResponseDto.class);
            accountInfoList.add(accountInfoResponseDto);
        });
        customerInfoResponseDto.setAccounts(accountInfoList);

        return customerInfoResponseDto;
    }


}
