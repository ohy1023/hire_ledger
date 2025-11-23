package com.example.hireledger.repository.account;

import com.example.hireledger.domain.entity.Account;
import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findByEmail(String email);
    void save(Account account);
}
