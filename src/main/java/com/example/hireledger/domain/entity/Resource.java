package com.example.hireledger.domain.entity;

import lombok.Data;

@Data
public class Resource {
    private Long id;
    private String resourceName;
    private String httpMethod;
    private int orderNum;
    private String resourceType;
}