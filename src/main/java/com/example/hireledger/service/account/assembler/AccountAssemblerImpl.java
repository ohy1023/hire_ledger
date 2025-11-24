package com.example.hireledger.service.account.assembler;

import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.utils.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountAssemblerImpl implements AccountAssembler {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Address toAddress(RegisterAccountDto req) {
        return Address.builder()
                .zipcode(req.getZipcode())
                .address(req.getAddress())
                .addressDetail(req.getAddressDetail())
                .build();

    }

    @Override
    public Account toAccount(Long addressId, RegisterAccountDto req) {
        return Account.builder()
                .uid(UUIDGenerator.generateUUIDv7())
                .email(req.getEmail())
                .username(req.getUsername())
                .tel(req.getTel())
                .gender(req.getGender())
                .password(passwordEncoder.encode(req.getPassword()))
                .birthDate(req.getBirthDate())
                .country(req.getCountry())
                .university(req.getUniversity())
                .workType(req.getWorkType())
                .addressId(addressId)
                .build();
    }
}
