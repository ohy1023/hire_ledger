package com.example.hireledger.service;

import com.example.hireledger.domain.dto.AccountRecord;
import com.example.hireledger.domain.dto.RegisterRecord;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.mapper.AccountMapper;
import com.example.hireledger.mapper.AccountRoleMapper;
import com.example.hireledger.mapper.AddressMapper;
import com.example.hireledger.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void createAccount(RegisterRecord registration) {
        String hashedPassword = encodePassword(registration.password());

        Address userAddress = buildAddress(registration);

        saveAccountWithRole(registration, hashedPassword, userAddress);
    }

    private String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    private Role fetchRoleByName(RoleType roleType) {
        return roleMapper.findByRoleName(roleType.name());
    }

    private Address buildAddress(RegisterRecord registration) {
        return registration.toAddress();
    }

    @Transactional
    protected void saveAccountWithRole(RegisterRecord registration, String hashedPassword,
                                       Address address) {
        Long addressId = saveAddress(address);
        Long accountId = saveAccount(registration, hashedPassword, addressId);
        assignRolesToAccount(accountId, registration.roleTypes());
    }

    private Long saveAddress(Address address) {
        addressMapper.save(address);
        return address.getId();
    }

    private Long saveAccount(RegisterRecord registration, String hashedPassword, Long addressId) {
        Account newAccount = registration.toAccount(hashedPassword, addressId);
        accountMapper.save(newAccount);
        return newAccount.getId();
    }

    private void linkAccountToRole(Long accountId, Long roleId) {
        accountRoleMapper.save(accountId, roleId);
    }

    private void assignRolesToAccount(Long accountId, List<RoleType> roleTypes) {
        for (RoleType roleType : roleTypes) {
            Role role = fetchRoleByName(roleType);
            linkAccountToRole(accountId, role.getId());
        }
    }

    @Override
    public AccountRecord getInfo(String email) {
        Account account = findAccountByEmail(email);
        Address address = findAddressById(account.getAddressId());
        List<Long> roleIds = findAccountRoleByAccountId(account.getId());

        List<Role> roles = roleMapper.findRolesByIds(roleIds);

        return buildAccountRecord(account, address, roles);
    }

    private Account findAccountByEmail(String email) {
        return accountMapper.findByEmail(email);
    }

    private Address findAddressById(Long addressId) {
        return addressMapper.findById(addressId);
    }

    private List<Long> findAccountRoleByAccountId(Long accountId) {
        return accountRoleMapper.findRolesByAccountId(accountId);
    }

    private AccountRecord buildAccountRecord(Account account, Address address, List<Role> roles) {
        return AccountRecord.from(account, address, roles);
    }
}