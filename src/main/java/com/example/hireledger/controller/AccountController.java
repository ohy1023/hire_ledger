package com.example.hireledger.controller;

import com.example.hireledger.domain.dto.AccountDto;
import com.example.hireledger.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "admin/registerAccount";
    }

    @GetMapping("/user/my-info")
    public String getInfoPage(Authentication authentication, Model model) {
        String email = authentication.getName();
        AccountDto accountDto = accountService.getInfo(email);
        model.addAttribute("accountDto", accountDto);
        return "user/mypage";
    }

}
