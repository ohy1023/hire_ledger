package com.example.hireledger.controller.restController;

import com.example.hireledger.domain.dto.ApiResponse;
import com.example.hireledger.domain.dto.EmployerCreateRequest;
import com.example.hireledger.service.employer.EmployerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@RequiredArgsConstructor
public class EmployerRestController {

    private EmployerService employerService;

    @PostMapping("/employers")
    public ResponseEntity<ApiResponse<String>> registerEmployer(@Valid @RequestBody EmployerCreateRequest employerCreateRequest, Authentication authentication) {
        String email = authentication.getName();
        employerService.createEmployer(email, employerCreateRequest);
        return ResponseEntity.ok(ApiResponse.success("고용주 등록 성공!"));
    }
}
