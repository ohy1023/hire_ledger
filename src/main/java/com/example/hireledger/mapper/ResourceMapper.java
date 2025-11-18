package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Resource;
import com.example.hireledger.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface ResourceMapper {
    List<Resource> findAllResources();
    Set<Role> findRoleByResource(Resource resource);
}
