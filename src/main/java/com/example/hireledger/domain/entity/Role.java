package com.example.hireledger.domain.entity;

import com.example.hireledger.domain.enums.RoleType;
import lombok.Data;

@Data
public class Role {
    private Long id;
    private RoleType roleType;
    private String description;
}