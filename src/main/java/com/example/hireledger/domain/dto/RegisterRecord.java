package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.utils.UUIDGenerator;

public record RegisterRecord (
        String username,
        String email,
        String password,
        String tel,
        Gender gender
) {
    public Account toEntity(String encodedPassword) {
        return Account.builder()
                .uid(UUIDGenerator.generateUUIDv7())
                .email(email)
                .username(username)
                .tel(tel)
                .gender(gender)
                .password(encodedPassword)
                .active(true)
                .build();

    }

}