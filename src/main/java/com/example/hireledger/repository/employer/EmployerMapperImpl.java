package com.example.hireledger.repository.employer;

import com.example.hireledger.domain.entity.Employer;
import com.example.hireledger.mapper.EmployerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployerMapperImpl implements EmployerRepository {

    private final EmployerMapper employerMapper;

    @Override
    public void save(Employer employer) {
        employerMapper.save(employer);
    }
}
