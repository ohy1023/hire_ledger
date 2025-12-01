package com.example.hireledger.repository.address;

import com.example.hireledger.domain.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    Optional<Address> findById(Long id);
    void save(Address address);
    List<Address> findByIds(List<Long> ids);
}
