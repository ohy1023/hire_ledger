package com.example.hireledger.repository.employer;

import com.example.hireledger.domain.entity.Employer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployerRepository {
    void save(Employer employer);
    
    Optional<Employer> findByAccountIdAndUuid(Long accountId, UUID uuid);
    
    List<Employer> findByAccountIdWithPaging(Long accountId, int offset, int size);

    long countByAccountId(Long accountId);
}