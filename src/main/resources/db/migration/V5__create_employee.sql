CREATE TABLE IF NOT EXISTS employee (
    id BIGINT PRIMARY KEY  AUTO_INCREMENT,
    address_id BIGINT NULL,
    account_id BIGINT NOT NULL,
    uid BINARY(16) NOT NULL COMMENT 'UUID 기반 고용주 고유 식별자',
    name VARCHAR(100) NOT NULL COMMENT '고용인 이름 (필수)',
    birth_date DATE NULL COMMENT '생년월일',
    tel VARCHAR(20) NOT NULL COMMENT '전화번호',
    gender ENUM('MALE', 'FEMALE') NULL COMMENT '성별',
    type VARCHAR(100) NULL COMMENT '고용인 유형 (예: 식당, 가정집 등)',
    img_url VARCHAR(500) NULL COMMENT '고용인 사진',
    note VARCHAR(500) NULL COMMENT '고용주 관련 메모 또는 추가 정보',
    university VARCHAR(100) NULL COMMENT '대학교',
    country VARCHAR(100) NULL COMMENT '국가',
    work_type VARCHAR(100) NULL COMMENT '근로 유형(정규직, 일용직)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시간',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 시간',
    deleted_at TIMESTAMP DEFAULT NULL COMMENT '삭제 시간(Soft Delete)',

    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL,
    FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE
);