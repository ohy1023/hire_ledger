package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Employer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface EmployerMapper {

    void save(Employer employer);

    Optional<Employer> findByAccountIdAndUuid(
            @Param("accountId") Long accountId,
            @Param("uuid") UUID uuid
    );

    List<Employer> findByAccountIdWithPaging(
            @Param("accountId") Long accountId,
            @Param("offset") int offset,
            @Param("size") int size
    );

    long countByAccountId(@Param("accountId") Long accountId);
}
