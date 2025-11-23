package com.example.hireledger.repository.resource;

import com.example.hireledger.domain.entity.Resource;
import com.example.hireledger.domain.entity.Role;
import com.example.hireledger.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ResourceRepositoryImpl implements ResourceRepository {

    private final ResourceMapper resourceMapper;

    @Override
    public List<Resource> findAllResources() {
        return resourceMapper.findAllResources();
    }

    @Override
    public Set<Role> findRoleByResource(Resource resource) {
        return resourceMapper.findRoleByResource(resource);
    }
}
