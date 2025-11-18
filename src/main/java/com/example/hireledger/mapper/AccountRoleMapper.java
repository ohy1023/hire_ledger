package com.example.hireledger.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountRoleMapper {
    @Insert("INSERT INTO account_role (account_id, role_id) VALUES (#{accountId}, #{roleId})")
    void save(@Param("accountId") Long accountId, @Param("roleId") Long roleId);

    List<Long> findRolesByAccountId(Long accountId);
}