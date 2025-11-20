package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    Role findByRoleName(String roleName);

    List<Role> findRolesByIds(List<Long> ids);

}