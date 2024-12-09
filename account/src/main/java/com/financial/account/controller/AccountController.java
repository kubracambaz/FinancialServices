package com.financial.account.controller;

import com.financial.account.domain.dto.AccountRequestDto;
import com.financial.account.domain.dto.AccountResponseDto;
import com.financial.account.domain.request.AccountRequest;
import com.financial.account.domain.response.AccountResponse;
import com.financial.account.domain.response.CustomerResponse;
import com.financial.account.service.AccountService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/accounts")
public class AccountController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountService service;

    @ApiOperation(value = "Create new account", nickname = "createAccount", notes = "Create new account with customerId and credit ")
    @PostMapping("/account")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody @Valid AccountRequest request) {
        AccountRequestDto requestDto = modelMapper.map(request, AccountRequestDto.class);
        AccountResponseDto responseDto = service.createAccount(requestDto);
        AccountResponse accountResponse = modelMapper.map(responseDto, AccountResponse.class);
        ResponseEntity<AccountResponse> response = new ResponseEntity<AccountResponse>(accountResponse, HttpStatus.CREATED);
        return response;
    }
}
