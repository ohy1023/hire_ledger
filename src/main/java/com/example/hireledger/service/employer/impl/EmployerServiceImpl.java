package com.example.hireledger.service.employer.impl;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.dto.EmployerDto;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.domain.entity.Employer;
import com.example.hireledger.exception.AppException;
import com.example.hireledger.repository.account.AccountRepository;
import com.example.hireledger.repository.address.AddressRepository;
import com.example.hireledger.repository.employer.EmployerRepository;
import com.example.hireledger.service.employer.EmployerService;
import com.example.hireledger.service.employer.EmployerTransactionalService;
import com.example.hireledger.service.employer.assembler.EmployerAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.hireledger.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final AccountRepository accountRepository;
    private final EmployerRepository employerRepository;
    private final AddressRepository addressRepository;
    private final EmployerAssembler employerAssembler;
    private final EmployerTransactionalService employerTransactionalService;

    @Override
    public void createEmployer(String email, EmployerCreateRequest employerCreateRequest) {
        Account account = findAccountByEmail(email);

        Address address = employerAssembler.toAddress(employerCreateRequest);

        employerTransactionalService.saveEmployer(account.getId(), address, employerCreateRequest);
    }



    @Override
    public EmployerDto getEmployer(String email, UUID uuid) {
        Account account = findAccountByEmail(email);
        Employer employer = findEmployerByAccountIdAndUuid(account.getId(), uuid);
        Address address = findAddressByEmployer(employer.getAddressId());
        return employerAssembler.toEmployerDto(employer, address);
    }



    @Override
    public List<EmployerDto> getEmployers(String email, int page, int size) {
        Account account = findAccountByEmail(email);
        int offset = (page - 1) * size;
        List<Employer> employers = employerRepository.findByAccountIdWithPaging(account.getId(), offset, size);

        List<Long> addressIds = employers.stream()
                .map(Employer::getAddressId)
                .toList();

        List<Address> addresses = addressRepository.findByIds(addressIds);
        return employerAssembler.toEmployers(employers, addresses);
    }

    @Override
    public long getEmployerCount(String email) {
        Account account = findAccountByEmail(email);
        return employerRepository.countByAccountId(account.getId());
    }

    /**
     * 이메일로 계정을 조회합니다.
     *
     * @param email 이메일
     * @return 계정 엔티티
     */
    private Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email).orElseThrow(() -> new AppException(ACCOUNT_NOT_FOUND));
    }

    /**
     *
     * @param accountId 계정 ID
     * @param uuid 고용주 식별 번호
     * @return 고용주 엔티티
     */
    private Employer findEmployerByAccountIdAndUuid(Long accountId, UUID uuid) {
        return employerRepository.findByAccountIdAndUuid(accountId, uuid)
                .orElseThrow(() -> new AppException(EMPLOYER_NOT_FOUND));
    }

    /**
     *
     * @param id 주소 ID
     * @return 주소 엔티티
     */
    private Address findAddressByEmployer(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AppException(ADDRESS_NOT_FOUND));
    }


}
