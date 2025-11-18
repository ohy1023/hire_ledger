package com.example.hireledger.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableJdbcHttpSession  // JDBC 기반 세션 활성화
public class SessionConfig {
}
