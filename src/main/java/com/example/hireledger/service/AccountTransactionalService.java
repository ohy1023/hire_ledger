package com.example.hireledger.service;

import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.domain.entity.Address;

public interface AccountTransactionalService {
    void saveAccountWithRole(RegisterAccountDto registration, String hashedPassword, Address address);
}