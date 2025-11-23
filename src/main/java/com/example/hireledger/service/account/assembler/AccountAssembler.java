package com.example.hireledger.service.account.assembler;

import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;

public interface AccountAssembler {
    Address toAddress(RegisterAccountDto req);
    Account toAccount(Long addressId, RegisterAccountDto req);
}
