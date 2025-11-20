package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.domain.enums.WorkType;
import com.example.hireledger.utils.UUIDGenerator;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class RegisterDto {

    private String username;
    private String email;
    private String password;
    private String tel;
    private Gender gender;
    private LocalDate birthDate;
    private String country;
    private String university;
    private WorkType workType;
    private List<RoleType> roleTypes;
    private String zipcode;
    private String address;
    private String addressDetail;

    // Address 변환
    public Address toAddress() {
        return Address.builder()
                .zipcode(zipcode)
                .address(address)
                .addressDetail(addressDetail)
                .build();
    }

    // Account 변환
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
