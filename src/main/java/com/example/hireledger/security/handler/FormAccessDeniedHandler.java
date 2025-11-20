package com.example.hireledger.security.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class FormAccessDeniedHandler implements AccessDeniedHandler {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private final String errorPage;

    public FormAccessDeniedHandler(String errorPage) {
        this.errorPage = errorPage;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {

        String errorMessage = "Access Denied: " + accessDeniedException.getMessage();
        String encodedMessage = URLEncoder.encode(errorMessage, StandardCharsets.UTF_8);

        String deniedUrl = errorPage + "?message=" + encodedMessage;
        redirectStrategy.sendRedirect(request, response, deniedUrl);

    }
}