package com.example.hireledger.controller.restController;

import com.example.hireledger.domain.dto.ApiResponse;
import com.example.hireledger.domain.dto.RegisterAccountDto;
import com.example.hireledger.service.account.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @PostMapping("/admin/register")
    public ResponseEntity<ApiResponse<String>> register(@Valid @RequestBody RegisterAccountDto registerAccountDto) {
        accountService.createAccount(registerAccountDto);
        return ResponseEntity.ok(ApiResponse.success("회원가입 성공!"));
    }

}
