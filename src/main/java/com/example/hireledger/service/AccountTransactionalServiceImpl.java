package com.example.hireledger.service;

import com.example.hireledger.domain.dto.RegisterRecord;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.mapper.AccountMapper;
import com.example.hireledger.mapper.AddressMapper;
import com.example.hireledger.mapper.RoleMapper;
import com.example.hireledger.mapper.AccountRoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountTransactionalServiceImpl implements AccountTransactionalService {

    private final AccountMapper accountMapper;
    private final AddressMapper addressMapper;
    private final RoleMapper roleMapper;
    private final AccountRoleMapper accountRoleMapper;

    @Override
    @Transactional
    public void saveAccountWithRole(RegisterRecord registration, String hashedPassword, Address address) {
        // 1. 주소 저장
        addressMapper.save(address);
        Long addressId = address.getId();

        // 2. 계정 저장
        Account account = registration.toAccount(hashedPassword, addressId);
        accountMapper.save(account);
        Long accountId = account.getId();

        // 3. 역할 매핑
        for (RoleType roleType : registration.roleTypes()) {
            Role role = roleMapper.findByRoleName(roleType.name());
            accountRoleMapper.save(accountId, role.getId());
        }
    }

}
