package com.example.hireledger.service.employer.assembler;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.dto.EmployerDto;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Employer;
import com.example.hireledger.utils.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
                .employerType(req.getEmployerType())
                .note(req.getNote())
                .build();
    }

    @Override
    public EmployerDto toEmployerDto(Employer employer, Address address) {
        return EmployerDto.builder()
                .employerUid(employer.getUid())
                .employerName(employer.getName())
                .birthDate(employer.getBirthDate())
                .employerTel(employer.getTel())
                .emplyoerGender(employer.getGender())
                .employerType(employer.getEmployerType())
                .note(employer.getNote())
                .address(address.toString())
                .build();
    }

    @Override
    public List<EmployerDto> toEmployers(List<Employer> employers, List<Address> addresses) {
        return employers.stream()
                .map(employer -> {
                    return toEmployerDto(employer, Objects.requireNonNull(addresses.stream()
                            .filter(a -> a.getId().equals(employer.getAddressId()))
                            .findFirst()
                            .orElse(null)));
                })
                .toList();
    }
}
