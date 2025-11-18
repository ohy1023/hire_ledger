package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    Account findByEmail(String email);

    void save(Account account);
}