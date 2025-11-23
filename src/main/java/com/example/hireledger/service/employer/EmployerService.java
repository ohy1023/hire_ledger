package com.example.hireledger.service.employer;

import com.example.hireledger.domain.dto.EmployerCreateRequest;

public interface EmployerService {
    void createEmployer(String email, EmployerCreateRequest employerCreateRequest);
}
