package com.example.hireledger.repository.address;

import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressMapper addressMapper;

    @Override
    public Optional<Address> findById(Long id) {
        return addressMapper.findById(id);
    }

    @Override
    public void save(Address address) {
        addressMapper.save(address);
    }

    @Override
    public List<Address> findByIds(List<Long> ids) {
        return addressMapper.findByIds(ids);
    }
}
