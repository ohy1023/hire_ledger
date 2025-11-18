package com.example.hireledger.domain.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Role {
    private Long id;
    private String roleName;
    private String description;
    private Set<Resource> resources = new HashSet<>();
}