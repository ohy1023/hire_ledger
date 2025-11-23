package com.example.hireledger.service.employer.assembler;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Employer;

public interface EmployerAssembler {
    Address toAddress(EmployerCreateRequest req);
    Employer toEmployer(Long accountId, Long addressId, EmployerCreateRequest req);
}
