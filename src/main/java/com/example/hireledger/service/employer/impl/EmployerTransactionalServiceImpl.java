package com.example.hireledger.service.employer.impl;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Employer;
import com.example.hireledger.repository.address.AddressRepository;
import com.example.hireledger.repository.employer.EmployerRepository;
import com.example.hireledger.service.employer.EmployerTransactionalService;
import com.example.hireledger.service.employer.assembler.EmployerAssembler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployerTransactionalServiceImpl implements EmployerTransactionalService {

    private final EmployerRepository employerRepository;
    private final AddressRepository addressRepository;
    private final EmployerAssembler employerAssembler;

    @Override
    @Transactional
    public void saveEmployer(Long accountId, Address address, EmployerCreateRequest request) {
        Long addressId = saveAddress(address);

        Employer employer = employerAssembler.toEmployer(accountId, addressId, request);

        employerRepository.save(employer);
    }


    /**
     * 주소를 저장하고 ID를 반환
     */
    private Long saveAddress(Address address) {
        addressRepository.save(address);
        Long addressId = address.getId();
        log.info("주소 저장 완료 - addressId: {}", addressId);
        return addressId;
    }

}
