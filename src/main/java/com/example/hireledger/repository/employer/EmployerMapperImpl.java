package com.example.hireledger.repository.employer;

import com.example.hireledger.domain.entity.Employer;
import com.example.hireledger.mapper.EmployerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class EmployerMapperImpl implements EmployerRepository {

    private final EmployerMapper employerMapper;

    @Override
    public void save(Employer employer) {
        employerMapper.save(employer);
    }

    @Override
    public Optional<Employer> findByAccountIdAndUuid(Long accountId, UUID uuid) {
        return employerMapper.findByAccountIdAndUuid(accountId, uuid);
    }

    @Override
    public List<Employer> findByAccountIdWithPaging(Long accountId, int offset, int size) {
        return employerMapper.findByAccountIdWithPaging(accountId, offset, size);
    }

    @Override
    public long countByAccountId(Long accountId) {
        return employerMapper.countByAccountId(accountId);
    }

}
