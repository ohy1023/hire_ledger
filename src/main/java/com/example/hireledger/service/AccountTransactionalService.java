package com.example.hireledger.service;

import com.example.hireledger.domain.dto.RegisterDto;
import com.example.hireledger.domain.entity.Address;

public interface AccountTransactionalService {
    void saveAccountWithRole(RegisterDto registration, String hashedPassword, Address address);
}