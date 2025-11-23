package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Employer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployerMapper {

    void save(Employer employer);
}
