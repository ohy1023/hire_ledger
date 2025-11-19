package com.example.hireledger.service;

import com.example.hireledger.domain.dto.AccountRecord;
import com.example.hireledger.domain.dto.RegisterRecord;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.mapper.AccountMapper;
import com.example.hireledger.mapper.AccountRoleMapper;
import com.example.hireledger.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountMapper accountMapper;
    private final RoleMapper roleMapper;
    private final AccountRoleMapper accountRoleMapper;

    @Override
    @Transactional
    public void createAccount(RegisterRecord registerRecord) {

        String encodedPassword = passwordEncoder.encode(registerRecord.password());

        Account account = registerRecord.toEntity(encodedPassword);
        accountMapper.save(account);

        Role role = roleMapper.findByRoleName("ROLE_USER"); // TODO 권한 ENUM 처리

        accountRoleMapper.save(account.getId(), role.getId());
    }
}
