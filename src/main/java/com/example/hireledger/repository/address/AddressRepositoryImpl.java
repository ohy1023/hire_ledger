package com.example.hireledger.repository.address;

import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressMapper addressMapper;

    @Override
    public Address findById(Long id) {
        return addressMapper.findById(id);
    }

    @Override
    public void save(Address address) {
        addressMapper.save(address);
    }
}
