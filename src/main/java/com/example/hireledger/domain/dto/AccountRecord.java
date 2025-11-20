package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.domain.enums.WorkType;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record AccountRecord(
        UUID accountUid,
        String username,
        String email,
        String tel,
        Gender gender,
        LocalDate birthDate,
        String country,
        WorkType workType,
        String faceUrl,
        String address,
        List<RoleType> roleTypes,
        LocalDateTime createdAt
) {

    public static AccountRecord from(Account account, Address address, List<Role> roles) {
        return AccountRecord.builder()
                .accountUid(account.getUid())
                .username(account.getUsername())
                .email(account.getEmail())
                .tel(account.getTel())
                .gender(account.getGender())
                .birthDate(account.getBirthDate())
                .country(account.getCountry())
                .workType(account.getWorkType())
                .faceUrl(account.getFaceUrl())
                .address(address.toString())
                .roleTypes(roles.stream().map(Role::getRoleType).toList())
                .createdAt(account.getCreatedAt())
                .build();
    }

    }
