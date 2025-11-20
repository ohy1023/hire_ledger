package com.example.hireledger.domain.enums;

import lombok.Getter;

@Getter
public enum RoleType {

    USER("ROLE_USER"),
    MANAGER("ROLE_MANAGER"),
    ADMIN("ROLE_ADMIN");

    private final String roleName;

    RoleType(String roleName) {
        this.roleName = roleName;
    }

}
