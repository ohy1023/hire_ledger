package com.example.hireledger.service.employer.impl;

import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.domain.entity.Account;
import com.example.hireledger.domain.entity.Address;
import com.example.hireledger.exception.AppException;
import com.example.hireledger.mapper.AccountMapper;
import com.example.hireledger.service.employer.EmployerService;
import com.example.hireledger.service.employer.EmployerTransactionalService;
import com.example.hireledger.service.employer.assembler.EmployerAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.hireledger.exception.ErrorCode.ACCOUNT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final AccountMapper accountMapper;
    private final EmployerAssembler employerAssembler;
    private final EmployerTransactionalService employerTransactionalService;

    @Override
    public void createEmployer(String email, EmployerCreateRequest employerCreateRequest) {
        Account account = findAccountByEmail(email);

        Address address = employerAssembler.toAddress(employerCreateRequest);

        employerTransactionalService.saveEmployer(account.getId(), address, employerCreateRequest);
    }


    /**
     * 이메일로 계정을 조회합니다.
     *
     * @param email 이메일
     * @return 계정 엔티티
     */
    private Account findAccountByEmail(String email) {
        return accountMapper.findByEmail(email).orElseThrow(() -> new AppException(ACCOUNT_NOT_FOUND));
    }


}
