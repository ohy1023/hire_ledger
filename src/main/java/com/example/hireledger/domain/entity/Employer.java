package com.example.hireledger.domain.entity;

import com.example.hireledger.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employer {
    private Long id;
    private UUID uid;
    private String name;
    private LocalDate birthDate;
    private String tel;
    private Gender gender;
    private String type;
    private String note;
    private Long accountId;
    private Long addressId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
