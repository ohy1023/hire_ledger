package com.example.hireledger.controller;

import com.example.hireledger.domain.dto.AccountDto;
import com.example.hireledger.domain.dto.RegisterDto;
import com.example.hireledger.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/admin/register")
    public String register(@ModelAttribute RegisterDto registerDto) {
        accountService.createAccount(registerDto);
        return "redirect:/";
    }

    @GetMapping("/user/my-info")
    public String getInfoPage(Authentication authentication, Model model) {
        String email = authentication.getName();
        AccountDto accountDto = accountService.getInfo(email);
        model.addAttribute("accountDto", accountDto);
        return "mypage";
    }

}
