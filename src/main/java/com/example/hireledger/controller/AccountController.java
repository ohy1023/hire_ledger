package com.example.hireledger.controller;

import com.example.hireledger.domain.dto.AccountDto;
import com.example.hireledger.service.account.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/user/delete-account")
    public String deleteAccount(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        String email = authentication.getName();

        // 계정 삭제
        accountService.deleteAccount(email);

        // 로그아웃 처리
        new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "redirect:/";
    }

}
