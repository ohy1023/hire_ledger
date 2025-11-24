package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AccountMapper {
    Optional<Account> findByEmail(String email);

    void save(Account account);

    void deleteById(Long id);

}