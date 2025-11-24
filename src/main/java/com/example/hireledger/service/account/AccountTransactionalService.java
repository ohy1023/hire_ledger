package com.example.hireledger.service.account;

import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.domain.entity.Address;

public interface AccountTransactionalService {
    void saveAccountWithRole(RegisterAccountDto registration, Address address);

    void deleteAccount(Long accountId);
}