package com.example.hireledger.service;


import com.example.hireledger.domain.dto.AccountDto;
import com.example.hireledger.domain.dto.RegisterDto;

public interface AccountService {

    void createAccount(RegisterDto registerDto);

    AccountDto getInfo(String email);

}

