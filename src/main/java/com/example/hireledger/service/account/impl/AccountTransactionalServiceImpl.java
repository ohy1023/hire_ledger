package com.example.hireledger.service.account.impl;


import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.repository.account.AccountRepository;
import com.example.hireledger.repository.accoutRole.AccountRoleRepository;
import com.example.hireledger.repository.address.AddressRepository;
import com.example.hireledger.repository.role.RoleRepository;
import com.example.hireledger.service.account.AccountTransactionalService;
import com.example.hireledger.service.account.assembler.AccountAssembler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountTransactionalServiceImpl implements AccountTransactionalService {

    private final AccountRepository accountRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final AccountRoleRepository accountRoleRepository;
    private final AccountAssembler accountAssembler;

    @Override
    @Transactional
    public void saveAccountWithRole(RegisterAccountDto registration, Address address) {
        // 1. 주소 저장
        Long addressId = saveAddress(address);

        // 2. 계정 저장
        Long accountId = saveAccount(registration, addressId);

        // 3. 역할 매핑
        assignRolesToAccount(accountId, registration.getRoleTypes());

        log.info("계정 생성 완료 - accountId: {}, email: {}", accountId, registration.getEmail());
    }

    @Override
    public void deleteAccount(Long AccountId) {
        accountRepository.deleteById(AccountId);
    }

    /**
     * 주소를 저장하고 ID를 반환
     */
    private Long saveAddress(Address address) {
        addressRepository.save(address);
        Long addressId = address.getId();
        log.info("주소 저장 완료 - addressId: {}", addressId);
        return addressId;
    }

    /**
     * 계정을 저장하고 ID를 반환
     */
    private Long saveAccount(RegisterAccountDto registration, Long addressId) {
        Account account = accountAssembler.toAccount(addressId, registration);
        accountRepository.save(account);
        Long accountId = account.getId();
        log.info("계정 저장 완료 - accountId: {}, email: {}", accountId, registration.getEmail());
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
        log.info("역할 할당 완료 - accountId: {}, roles: {}", accountId, roleTypes);
    }

    /**
     * 역할 타입으로 역할 ID 조회
     */
    private Long findRoleIdByType(RoleType roleType) {
        Role role = roleRepository.findByRoleName(roleType.name());
        return role.getId();
    }

    /**
     * 계정과 역할을 연결
     */
    private void linkAccountAndRole(Long accountId, Long roleId) {
        accountRoleRepository.save(accountId, roleId);
        log.info("계정-역할 연결 완료 - accountId: {}, roleId: {}", accountId, roleId);
    }
}