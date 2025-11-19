package com.example.hireledger.security.service;


import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.domain.dto.AccountContext;
import com.example.hireledger.domain.dto.AccountRecord;
import com.example.hireledger.mapper.AccountMapper;
import com.example.hireledger.mapper.AccountRoleMapper;
import com.example.hireledger.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")
@RequiredArgsConstructor
public class FormUserDetailsService implements UserDetailsService {

    private final AccountMapper accountMapper;
    private final AccountRoleMapper accountRoleMapper;
    private final RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountMapper.findByEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        List<Long> roleIds = accountRoleMapper.findRolesByAccountId(account.getId());

        List<Role> roles = roleMapper.findRolesByIds(roleIds);

        List<GrantedAuthority> authorities = roles.stream()
                .map(Role::getRoleName) // ex) "ROLE_ADMIN", "ROLE_USER"
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        AccountRecord accountRecord = AccountRecord.from(account);

        return new AccountContext(accountRecord, authorities);
    }
}