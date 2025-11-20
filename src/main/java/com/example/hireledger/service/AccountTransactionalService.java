package com.example.hireledger.service;

import com.example.hireledger.domain.dto.RegisterRecord;
import com.example.hireledger.domain.entity.Address;

public interface AccountTransactionalService {
    void saveAccountWithRole(RegisterRecord registration, String hashedPassword, Address address);
}