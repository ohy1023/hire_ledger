CREATE TABLE IF NOT EXISTS transaction_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    account_id BIGINT NOT NULL,
    employer_id BIGINT NULL,
    employee_id BIGINT NULL,
    uid BINARY(16) NULL COMMENT 'UUID 기반 사용자 고유 식별자',
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '거래 날짜',
    amount DECIMAL(15,2) NULL COMMENT '거래 총합',
    description VARCHAR(500) NULL COMMENT '거래 상세 정보',
    type ENUM('INCOME','EXPENSE') NULL COMMENT '거래 유형: 수입/지출',
    category VARCHAR(100) NULL COMMENT '세부 거래 분류 (예: 수수료, 환불, 책상비)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '거래 생성 시간',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '거래 수정 시간',
    deleted_at TIMESTAMP NULL COMMENT '거래 삭제 시간',

    FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE,
    FOREIGN KEY (employer_id) REFERENCES account(id) ON DELETE SET NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE SET NULL
);