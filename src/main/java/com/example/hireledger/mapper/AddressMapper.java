package com.example.hireledger.mapper;

import com.example.hireledger.domain.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AddressMapper {
    Optional<Address> findById(Long id);

    void save(Address address);

    List<Address> findByIds(@Param("ids") List<Long> ids);
}
