package com.example.hireledger.repository.account;

import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountMapper accountMapper; // MyBatis Mapper

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountMapper.findByEmail(email);
    }

    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }
}
