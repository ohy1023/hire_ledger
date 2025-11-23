package com.example.hireledger.domain.dto;

import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerCreateRequest {

    @NotBlank(message = "이름은 비어 있을 수 없습니다.")
    private String employerName;

    @NotNull(message = "생년월일은 필수입니다.")
    @Past(message = "생년월일은 과거 날짜여야 합니다.")
    private LocalDate birthDate;

    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(
        regexp = "^01[0-9]-?[0-9]{3,4}-?[0-9]{4}$",
        message = "전화번호 형식이 올바르지 않습니다."
    )
    private String employerTel;

    @NotNull(message = "성별은 필수입니다.")
    private Gender emplyoerGender;

    @NotBlank(message = "고용주 유형은 필수입니다.")
    private String employerType;

    @NotBlank(message = "우편번호는 필수입니다.")
    private String zipcode;

    @NotBlank(message = "주소는 필수입니다.")
    private String address;

    private String addressDetail;
    private String note;

    public Address toAddress(EmployerCreateRequest req) {
        return Address.builder()
                .zipcode(req.getZipcode())
                .address(req.getAddress())
                .addressDetail(req.getAddressDetail())
                .build();
    }
}
