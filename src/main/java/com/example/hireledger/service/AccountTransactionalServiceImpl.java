package com.example.hireledger.service;


import com.example.hireledger.domain.dto.RegisterAccountDto;
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

import java.util.List;

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
    public void saveAccountWithRole(RegisterAccountDto registration, String hashedPassword, Address address) {
        // 1. 주소 저장
        Long addressId = saveAddress(address);

        // 2. 계정 저장
        Long accountId = saveAccount(registration, hashedPassword, addressId);

        // 3. 역할 매핑
        assignRolesToAccount(accountId, registration.getRoleTypes());

        log.info("계정 생성 완료 - accountId: {}, email: {}", accountId, registration.getEmail());
    }

    /**
     * 주소를 저장하고 ID를 반환
     */
    private Long saveAddress(Address address) {
        addressMapper.save(address);
        Long addressId = address.getId();
        log.debug("주소 저장 완료 - addressId: {}", addressId);
        return addressId;
    }

    /**
     * 계정을 저장하고 ID를 반환
     */
    private Long saveAccount(RegisterAccountDto registration, String hashedPassword, Long addressId) {
        Account account = registration.toAccount(hashedPassword, addressId);
        accountMapper.save(account);
        Long accountId = account.getId();
        log.debug("계정 저장 완료 - accountId: {}, email: {}", accountId, registration.getEmail());
        return accountId;
    }

    /**
     * 계정에 역할들을 할당
     */
    private void assignRolesToAccount(Long accountId, List<RoleType> roleTypes) {
        for (RoleType roleType : roleTypes) {
            Long roleId = findRoleIdByType(roleType);
            linkAccountAndRole(accountId, roleId);
        }
        log.debug("역할 할당 완료 - accountId: {}, roles: {}", accountId, roleTypes);
    }

    /**
     * 역할 타입으로 역할 ID 조회
     */
    private Long findRoleIdByType(RoleType roleType) {
        Role role = roleMapper.findByRoleName(roleType.name());
        return role.getId();
    }

    /**
     * 계정과 역할을 연결
     */
    private void linkAccountAndRole(Long accountId, Long roleId) {
        accountRoleMapper.save(accountId, roleId);
        log.trace("계정-역할 연결 완료 - accountId: {}, roleId: {}", accountId, roleId);
    }
}