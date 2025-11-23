package com.example.hireledger.repository.role;

import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleMapper roleMapper;

    @Override
    public Role findByRoleName(String roleName) {
        return roleMapper.findByRoleName(roleName);
    }

    @Override
    public List<Role> findRolesByIds(List<Long> ids) {
        return roleMapper.findRolesByIds(ids);
    }
}
