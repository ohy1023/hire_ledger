package com.example.hireledger.repository.address;

import com.example.hireledger.domain.entity.Address;

public interface AddressRepository {
    Address findById(Long id);
    void save(Address address);
}
