package com.financial.account.controller;

import com.financial.account.domain.dto.AccountResponseDto;
import com.financial.account.domain.dto.CustomerInfoResponseDto;
import com.financial.account.domain.dto.CustomerRequestDto;
import com.financial.account.domain.dto.CustomerResponseDto;
import com.financial.account.domain.request.CustomerRequest;
import com.financial.account.domain.response.AccountResponse;
import com.financial.account.domain.response.CustomerInfoResponse;
import com.financial.account.domain.response.CustomerResponse;
import com.financial.account.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/customers")
public class CustomerController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerService service;

    @ApiOperation(value = "Create new customer", nickname = "createCustomer", notes = "Create new customer with name and surname ")
    @PostMapping("/customer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest request) {
        CustomerRequestDto requestDto = modelMapper.map(request, CustomerRequestDto.class);
        CustomerResponseDto responseDto = service.createCustomer(requestDto);
        CustomerResponse customerResponse = modelMapper.map(responseDto, CustomerResponse.class);
        ResponseEntity<CustomerResponse> response = new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.CREATED);
        return response;
    }

    @ApiOperation(value = "Get customer", nickname = "getCustomer", notes = "Get a customer by id ")
    @GetMapping(value = "/getCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerInfoResponse> getCustomer(@RequestParam Long customerId) {

        CustomerInfoResponseDto responseDto = service.getCustomer(customerId);
        CustomerInfoResponse customerResponse = modelMapper.map(responseDto,CustomerInfoResponse.class);
        ResponseEntity<CustomerInfoResponse> response = new ResponseEntity<CustomerInfoResponse>(customerResponse, HttpStatus.OK);
        return response;
    }
}
