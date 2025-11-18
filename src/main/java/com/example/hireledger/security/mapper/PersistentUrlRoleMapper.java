package com.example.hireledger.security.mapper;

import com.example.hireledger.domain.entity.Resource;
import com.example.hireledger.mapper.ResourceMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PersistentUrlRoleMapper implements UrlRoleMapper {

    private final LinkedHashMap<String, String> urlRoleMappings = new LinkedHashMap<>();
    private final ResourceMapper resourceMapper;

    public PersistentUrlRoleMapper(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Map<String, String> getUrlRoleMappings() {
        urlRoleMappings.clear();
        List<Resource> resourcesList = resourceMapper.findAllResources();
        resourcesList.forEach(re -> {
            resourceMapper.findRoleByResource(re).forEach(role -> {
                urlRoleMappings.put(re.getResourceName(), role.getRoleName());
            });
        });
        return urlRoleMappings;
    }
}