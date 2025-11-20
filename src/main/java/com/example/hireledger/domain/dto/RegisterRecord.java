package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.domain.enums.WorkType;
import com.example.hireledger.utils.UUIDGenerator;

import java.time.LocalDate;
import java.util.List;

public record RegisterRecord (
        String username,
        String email,
        String password,
        String tel,
        Gender gender,
        LocalDate birthDate,
        String country,
        String university,
        WorkType workType,
        List<RoleType> roleTypes,
        String zipcode,
        String address,
        String addressDetail
) {
    public Address toAddress() {
        return Address.builder()
                .zipcode(zipcode)
                .address(address)
                .addressDetail(addressDetail)
                .build();
    }

    public Account toAccount(String encodedPassword, Long addressId) {
        return Account.builder()
                .uid(UUIDGenerator.generateUUIDv7())
                .email(email)
                .username(username)
                .tel(tel)
                .gender(gender)
                .password(encodedPassword)
                .active(true)
                .birthDate(birthDate)
                .country(country)
                .university(university)
                .workType(workType)
                .addressId(addressId)
                .build();

    }

}