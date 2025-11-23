package com.example.hireledger.service.employer.assembler;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Employer;
import com.example.hireledger.utils.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerAssemblerImpl implements EmployerAssembler {

    @Override
    public Address toAddress(EmployerCreateRequest req) {
        return Address.builder()
                .zipcode(req.getZipcode())
                .address(req.getAddress())
                .addressDetail(req.getAddressDetail())
                .build();
    }

    @Override
    public Employer toEmployer(Long accountId, Long addressId, EmployerCreateRequest req) {
        return Employer.builder()
                .uid(UUIDGenerator.generateUUIDv7())
                .accountId(accountId)
                .addressId(addressId)
                .name(req.getEmployerName())
                .birthDate(req.getBirthDate())
                .gender(req.getEmplyoerGender())
                .tel(req.getEmployerTel())
                .type(req.getEmployerType())
                .note(req.getNote())
                .build();
    }
}
