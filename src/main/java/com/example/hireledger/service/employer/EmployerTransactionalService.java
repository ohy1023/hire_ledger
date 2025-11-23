package com.example.hireledger.service.employer;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.entity.Address;

public interface EmployerTransactionalService {
    void saveEmployer(Long accountId, Address address, EmployerCreateRequest request);
}
