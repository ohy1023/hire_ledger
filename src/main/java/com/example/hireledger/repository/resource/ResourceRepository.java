package com.example.hireledger.repository.resource;

import com.example.hireledger.domain.entity.Resource;
import com.example.hireledger.domain.entity.Role;
import java.util.List;
import java.util.Set;

public interface ResourceRepository {
    List<Resource> findAllResources();
    Set<Role> findRoleByResource(Resource resource);
}
