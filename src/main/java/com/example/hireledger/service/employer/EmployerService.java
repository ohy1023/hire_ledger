package com.example.hireledger.service.employer;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.dto.EmployerDto;
import com.example.hireledger.domain.entity.Employer;

import java.util.List;
import java.util.UUID;

public interface EmployerService {
    void createEmployer(String email, EmployerCreateRequest employerCreateRequest);
    
    List<EmployerDto> getEmployers(String email, int page, int size);

    long getEmployerCount(String email);
    
    EmployerDto getEmployer(String email, UUID uuid);

}
