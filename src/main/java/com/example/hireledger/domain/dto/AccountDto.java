package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.domain.enums.WorkType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private UUID accountUid;
    private String username;
    private String email;
    private String tel;
    private Gender gender;
    private LocalDate birthDate;
    private String country;
    private WorkType workType;
    private String faceUrl;
    private String address;
    private List<RoleType> roleTypes;
    private LocalDateTime createdAt;

    public static AccountDto from(Account account, Address address, List<Role> roles) {
        return AccountDto.builder()
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

    public String getFormattedTel() {
        if (tel != null && tel.length() == 10) {
            return tel.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        }
        return tel;
    }
}
