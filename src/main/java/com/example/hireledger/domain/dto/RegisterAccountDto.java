package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.domain.enums.RoleType;
import com.example.hireledger.domain.enums.WorkType;
import com.example.hireledger.utils.UUIDGenerator;
import lombok.*;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAccountDto {

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    @Size(min = 2, max = 50, message = "이름은 2자 이상 50자 이하로 입력해주세요.")
    private String username;

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @Size(max = 100, message = "이메일은 100자를 초과할 수 없습니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 8, max = 100, message = "비밀번호는 8자 이상 100자 이하로 입력해주세요.")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "비밀번호는 영문, 숫자, 특수문자를 포함해야 합니다."
    )
    private String password;

    @Pattern(
            regexp = "^\\d{10,11}$",
            message = "전화번호 형식이 올바르지 않습니다. (예: 01012345678)"
    )
    private String tel;

    private Gender gender;

    @Past(message = "생년월일은 과거 날짜여야 합니다.")
    private LocalDate birthDate;

    @Size(max = 50, message = "국적은 50자를 초과할 수 없습니다.")
    private String country;

    @Size(max = 100, message = "대학명은 100자를 초과할 수 없습니다.")
    private String university;

    private WorkType workType;

    @NotEmpty(message = "최소 1개 이상의 권한을 선택해주세요.")
    private List<RoleType> roleTypes;

    @Pattern(
            regexp = "^\\d{5}$|^\\d{5}-\\d{4}$",
            message = "우편번호 형식이 올바르지 않습니다."
    )
    private String zipcode;

    @Size(max = 255, message = "주소는 255자를 초과할 수 없습니다.")
    private String address;

    @Size(max = 255, message = "상세 주소는 255자를 초과할 수 없습니다.")
    private String addressDetail;

}