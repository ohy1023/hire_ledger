package com.example.hireledger.service;


import com.example.hireledger.domain.dto.AccountDto;
import com.example.hireledger.domain.dto.RegisterAccountDto;

public interface AccountService {

    void createAccount(RegisterAccountDto registerAccountDto);

    AccountDto getInfo(String email);

}

