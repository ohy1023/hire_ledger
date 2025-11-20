package com.example.hireledger.service;


import com.example.hireledger.domain.dto.AccountRecord;
import com.example.hireledger.domain.dto.RegisterRecord;

public interface AccountService {

    void createAccount(RegisterRecord registerRecord);

    AccountRecord getInfo(String email);

}

