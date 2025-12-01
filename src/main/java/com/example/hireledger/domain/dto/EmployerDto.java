package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {

    private UUID employerUid;

    private String employerName;

    private LocalDate birthDate;

    private String employerTel;

    private Gender emplyoerGender;

    private String employerType;

    private String address;

    private String note;
}
