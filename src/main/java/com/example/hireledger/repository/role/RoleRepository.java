package com.example.hireledger.repository.role;

import com.example.hireledger.domain.entity.Role;
import java.util.List;

public interface RoleRepository {
    Role findByRoleName(String roleName);
    List<Role> findRolesByIds(List<Long> ids);
}
