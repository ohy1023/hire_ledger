package com.example.hireledger.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long id;
    private String zipcode;
    private String address;
    private String addressDetail;


    @Override
    public String toString() {
        return address + " " + addressDetail + " (" + zipcode + ")";
    }
}
