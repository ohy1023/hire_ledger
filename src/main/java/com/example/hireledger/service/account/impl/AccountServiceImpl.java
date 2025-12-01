package com.example.hireledger.service.account.impl;

import com.example.hireledger.domain.dto.AccountDto;
import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.exception.AppException;
import com.example.hireledger.repository.account.AccountRepository;
import com.example.hireledger.repository.accoutRole.AccountRoleRepository;
import com.example.hireledger.repository.address.AddressRepository;
import com.example.hireledger.repository.role.RoleRepository;
import com.example.hireledger.service.account.AccountService;
import com.example.hireledger.service.account.AccountTransactionalService;
import com.example.hireledger.service.account.assembler.AccountAssembler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hireledger.exception.ErrorCode.*;

/**
 * 계정 관리 서비스 구현체
 * 계정 생성, 조회 등의 비즈니스 로직을 처리합니다.
 */
@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final AccountRoleRepository accountRoleRepository;
    private final AccountAssembler accountAssembler;
    private final AccountTransactionalService accountTransactionalService;

    /**
     * 새로운 계정을 생성합니다.
     *
     * @param registration 회원가입 정보
     */
    @Override
    public void createAccount(RegisterAccountDto registration) {
        // email 중복 확인
        validateEmailNotExists(registration.getEmail());

        // 주소 엔티티 생성
        Address userAddress = accountAssembler.toAddress(registration);

        accountTransactionalService.saveAccountWithRole(registration, userAddress);
    }


    /**
     * 이메일로 계정 정보를 조회합니다.
     *
     * @param email 이메일
     * @return 계정 정보 DTO
     */
    @Override
    public AccountDto getInfo(String email) {
        // 1. 계정 조회
        Account account = findAccountByEmail(email);

        // 2. 주소 조회
        Address address = findAddressById(account.getAddressId());

        // 3. 계정의 역할 ID 목록 조회
        List<Long> roleIds = findAccountRoleByAccountId(account.getId());

        // 4. 역할 엔티티 목록 조회
        List<Role> roles = roleRepository.findRolesByIds(roleIds);

        // 5. Record로 변환하여 반환
        return buildAccountDto(account, address, roles);
    }

    /**
     * 이메일로 계정을 탈퇴합니다.
     *
     * @param email 이메일
     */
    @Override
    public void deleteAccount(String email) {
        Account account = findAccountByEmail(email);

        accountTransactionalService.deleteAccount(account.getId());
    }

    /**
     * 이메일 중복 여부를 검사하고, 이미 존재하면 예외를 던집니다.
     *
     * @param email 검사할 이메일
     */
    private void validateEmailNotExists(String email) {
        if (accountRepository.findByEmail(email).isPresent()) {
            throw new AppException(DUPLICATE_EMAIL);
        }
    }

    /**
     * 이메일로 계정을 조회합니다.
     *
     * @param email 이메일
     * @return 계정 엔티티
     */
    private Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email).orElseThrow(() -> new AppException(ACCOUNT_NOT_FOUND));
    }

    /**
     * ID로 주소를 조회합니다.
     *
     * @param addressId 주소 ID
     * @return 주소 엔티티
     */
    private Address findAddressById(Long addressId) {
        return addressRepository.findById(addressId).orElseThrow(() -> new AppException(ADDRESS_NOT_FOUND));
    }

    /**
     * 계정 ID로 역할 ID 목록을 조회합니다.
     *
     * @param accountId 계정 ID
     * @return 역할 ID 목록
     */
    private List<Long> findAccountRoleByAccountId(Long accountId) {
        return accountRoleRepository.findRolesByAccountId(accountId);
    }

    /**
     * 계정, 주소, 역할 정보를 DTO로 변환합니다.
     *
     * @param account 계정 엔티티
     * @param address 주소 엔티티
     * @param roles   역할 엔티티 목록
     * @return 계정 정보 DTO
     */
    private AccountDto buildAccountDto(Account account, Address address, List<Role> roles) {
        return AccountDto.from(account, address, roles);
    }
}