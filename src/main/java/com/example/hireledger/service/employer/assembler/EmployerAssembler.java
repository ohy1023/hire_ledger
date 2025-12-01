package com.example.hireledger.service.employer.assembler;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.dto.EmployerDto;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Employer;

import java.util.List;

public interface EmployerAssembler {
    Address toAddress(EmployerCreateRequest req);
    Employer toEmployer(Long accountId, Long addressId, EmployerCreateRequest req);

    EmployerDto toEmployerDto(Employer employer, Address address);
    List<EmployerDto> toEmployers(List<Employer> employers, List<Address> addresses);
}
