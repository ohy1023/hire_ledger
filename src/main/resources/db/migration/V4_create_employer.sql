CREATE TABLE IF NOT EXISTS employer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '고용주 고유 ID',
    uid BINARY(16) NOT NULL UNIQUE COMMENT 'UUID 기반 고용주 고유 식별자',

    name VARCHAR(100) NOT NULL COMMENT '고용주 이름 (필수)',
    birth_date DATE COMMENT '생년월일',
    tel VARCHAR(20) NOT NULL COMMENT '전화번호 (하이픈 포함, 필수)',
    gender ENUM('MALE','FEMALE') COMMENT '성별',
    employer_type VARCHAR(100) COMMENT '고용주 유형 (예: 식당, 가정집 등)',

    address_id BIGINT COMMENT '주소 ID(FK)',
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE,

    note VARCHAR(500) COMMENT '고용주 관련 메모 또는 추가 정보',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시간',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 시간',
    deleted_at TIMESTAMP DEFAULT NULL COMMENT '삭제 시간(Soft Delete)'
);
