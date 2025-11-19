CREATE TABLE persistent_logins (
    username VARCHAR(255) NOT NULL COMMENT '사용자 이름(로그인 ID)',
    series VARCHAR(64) PRIMARY KEY COMMENT '고유 시리즈 ID(쿠키 고유 식별자)',
    token VARCHAR(64) NOT NULL COMMENT '로그인 토큰 값',
    last_used TIMESTAMP NOT NULL COMMENT '마지막 사용 시각'
);