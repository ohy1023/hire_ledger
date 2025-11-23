package com.example.hireledger.repository.accoutRole;

import com.example.hireledger.mapper.AccountRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRoleRepositoryImpl implements AccountRoleRepository {

    private final AccountRoleMapper accountRoleMapper;

    @Override
    public void save(Long accountId, Long roleId) {
        accountRoleMapper.save(accountId, roleId);
    }

    @Override
    public List<Long> findRolesByAccountId(Long accountId) {
        return accountRoleMapper.findRolesByAccountId(accountId);
    }
}
