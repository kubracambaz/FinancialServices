package com.financial.account.service;

import com.financial.account.domain.dto.CustomerInfoResponseDto;
import com.financial.account.domain.dto.CustomerRequestDto;
import com.financial.account.domain.dto.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto requestDto);
    CustomerInfoResponseDto getCustomer(Long customerId);
}
