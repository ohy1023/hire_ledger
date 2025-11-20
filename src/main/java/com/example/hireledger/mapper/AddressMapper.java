package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    Address findById(Long id);

    void save(Address address);
}
