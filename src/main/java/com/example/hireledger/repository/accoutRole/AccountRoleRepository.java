package com.example.hireledger.repository.accoutRole;

import java.util.List;

public interface AccountRoleRepository {
    void save(Long accountId, Long roleId);
    List<Long> findRolesByAccountId(Long accountId);
}
