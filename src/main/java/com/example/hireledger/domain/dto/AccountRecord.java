package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.domain.entity.Role;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record AccountRecord(
        UUID uid,
        String username,
        String email,
        String password,
        String tel,
        Gender gender,
        boolean active,
        Set<String> roleNames // Role 객체 대신 이름만 가짐
) implements Serializable {
    public static AccountRecord from(Account account, List<Role> roleList) {
        return new AccountRecord(
                account.getUid(),
                account.getUsername(),
                account.getEmail(),
                account.getPassword(),
                account.getTel(),
                account.getGender(),
                account.isActive(),
                roleList.stream()
                        .map(Role::getRoleName)
                        .collect(Collectors.toSet())
        );
    }

}