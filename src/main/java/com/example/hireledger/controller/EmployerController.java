package com.example.hireledger.controller;

import com.example.hireledger.domain.dto.EmployerDto;
import com.example.hireledger.service.employer.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping("/employers")
    public String getEmployerList(
            @RequestParam(defaultValue = "1") int page,  // 현재 페이지
            @RequestParam(defaultValue = "10") int size, // 페이지당 요소 수
            Model model, Authentication authentication
    ) {

        String email = authentication.getName();
        List<EmployerDto> employers = employerService.getEmployers(email, page, size);
        long totalCount = employerService.getEmployerCount(email);
        long totalPages = (long) Math.ceil((double) totalCount / size);

        model.addAttribute("employers", employers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "employer/list";
    }

    @GetMapping("/employers/{uuid}")
    public String getEmployerDetail(@PathVariable UUID uuid, Model model, Authentication authentication) {
        String email = authentication.getName();
        EmployerDto employer = employerService.getEmployer(email, uuid);

        model.addAttribute("employer", employer);

        return "employer/detail";
    }
}

