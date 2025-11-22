package com.example.hireledger.service;

import com.example.hireledger.domain.dto.AccountDto;
import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.exception.AppException;
import com.example.hireledger.exception.ErrorCode;
import com.example.hireledger.mapper.AccountMapper;
import com.example.hireledger.mapper.AccountRoleMapper;
import com.example.hireledger.mapper.AddressMapper;
import com.example.hireledger.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 계정 관리 서비스 구현체
 * 계정 생성, 조회 등의 비즈니스 로직을 처리합니다.
 */
@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountMapper accountMapper;
    private final AddressMapper addressMapper;
    private final RoleMapper roleMapper;
    private final AccountRoleMapper accountRoleMapper;
    private final AccountTransactionalService accountTransactionalService;

    /**
     * 새로운 계정을 생성합니다.
     *
     * @param registration 회원가입 정보
     */
    @Override
    public void createAccount(RegisterAccountDto registration) {
        // email 중복 확인
        if (accountMapper.existsByEmail(registration.getEmail())) {
            throw new AppException(ErrorCode.DUPLICATE_EMAIL);
        }

        // 암호화 작업 수행
        String hashedPassword = encodePassword(registration.getPassword());

        // 주소 엔티티 생성
        Address userAddress = buildAddress(registration);

        accountTransactionalService.saveAccountWithRole(registration, hashedPassword, userAddress);
    }

    /**
     * 평문 비밀번호를 암호화합니다.
     *
     * @param rawPassword 평문 비밀번호
     * @return 암호화된 비밀번호
     */
    private String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * 역할 타입으로 역할 엔티티를 조회합니다.
     *
     * @param roleType 역할 타입
     * @return 역할 엔티티
     */
    private Role fetchRoleByName(RoleType roleType) {
        return roleMapper.findByRoleName(roleType.name());
    }

    /**
     * 회원가입 정보에서 주소 엔티티를 생성합니다.
     *
     * @param registration 회원가입 정보
     * @return 주소 엔티티
     */
    private Address buildAddress(RegisterAccountDto registration) {
        return registration.toAddress();
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
        List<Role> roles = roleMapper.findRolesByIds(roleIds);

        // 5. Record로 변환하여 반환
        return buildAccountDto(account, address, roles);
    }

    /**
     * 이메일로 계정을 조회합니다.
     *
     * @param email 이메일
     * @return 계정 엔티티
     */
    private Account findAccountByEmail(String email) {
        return accountMapper.findByEmail(email);
    }

    /**
     * ID로 주소를 조회합니다.
     *
     * @param addressId 주소 ID
     * @return 주소 엔티티
     */
    private Address findAddressById(Long addressId) {
        return addressMapper.findById(addressId);
    }

    /**
     * 계정 ID로 역할 ID 목록을 조회합니다.
     *
     * @param accountId 계정 ID
     * @return 역할 ID 목록
     */
    private List<Long> findAccountRoleByAccountId(Long accountId) {
        return accountRoleMapper.findRolesByAccountId(accountId);
    }

    /**
     * 계정, 주소, 역할 정보를 DTO로 변환합니다.
     *
     * @param account 계정 엔티티
     * @param address 주소 엔티티
     * @param roles 역할 엔티티 목록
     * @return 계정 정보 DTO
     */
    private AccountDto buildAccountDto(Account account, Address address, List<Role> roles) {
        return AccountDto.from(account, address, roles);
    }
}