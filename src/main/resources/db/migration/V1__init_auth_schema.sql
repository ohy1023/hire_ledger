-- 주소 테이블
CREATE TABLE address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '주소 고유 ID',
    zipcode VARCHAR(10) COMMENT '우편번호 (5자리, 변경 대비)',
    address VARCHAR(200) COMMENT '기본 주소(도로명 또는 지번)',
    address_detail VARCHAR(200) COMMENT '상세 주소(건물명, 동호수 등)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시점',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 시점'
);

-- 계정 테이블
CREATE TABLE account (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '계정 고유 ID',
    uid BINARY(16) NOT NULL UNIQUE COMMENT 'UUID 기반 사용자 고유 식별자',
    username VARCHAR(100) NOT NULL COMMENT '사용자 이름',
    password VARCHAR(255) NOT NULL COMMENT '비밀번호(암호화 저장)',
    email VARCHAR(150) NOT NULL UNIQUE COMMENT '사용자 이메일',
    tel VARCHAR(20) COMMENT '전화번호 (하이픈 포함, 예: 010-1234-5678)',
    gender VARCHAR(20) COMMENT '성별 (예: MALE, FEMALE 등)',
    active BOOLEAN DEFAULT TRUE COMMENT '계정 활성 여부',
    birth_date DATE COMMENT '생년월일',
    country VARCHAR(100) COMMENT '국적',
    university VARCHAR(200) COMMENT '대학명',
    work_type VARCHAR(30) COMMENT '근로 유형 (예: FULL_TIME, INTERN 등)',
    face_image_url VARCHAR(500) COMMENT '얼굴 이미지 URL',
    address_id BIGINT COMMENT '주소 ID(FK)',
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '계정 생성 시간',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '계정 정보 수정 시간',
    deleted_at TIMESTAMP DEFAULT NULL COMMENT '계정 삭제 시간(Soft Delete)'
);

-- 권한(Role)
CREATE TABLE role (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '권한 고유 ID',
    role_type VARCHAR(20) NOT NULL UNIQUE COMMENT '권한명 (예: USER, MANAGER, ADMIN)',
    description VARCHAR(200) COMMENT '권한 설명'
);

-- 리소스(Resource)
CREATE TABLE resource (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '리소스 고유 ID',
    resource_name VARCHAR(100) NOT NULL COMMENT '리소스 이름 (예: Admin Dashboard)',
    http_method VARCHAR(20) COMMENT 'HTTP 메서드 (GET, POST 등)',
    order_num INT COMMENT '리소스 접근 순서',
    resource_type VARCHAR(200) COMMENT '리소스 유형 (URL, METHOD 등)'
);

-- 계정-권한 매핑
CREATE TABLE account_role (
    account_id BIGINT NOT NULL COMMENT '계정 ID',
    role_id BIGINT NOT NULL COMMENT '권한 ID',
    PRIMARY KEY (account_id, role_id),
    FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
);

-- 권한-리소스 매핑
CREATE TABLE role_resource (
    role_id BIGINT NOT NULL COMMENT '권한 ID',
    resource_id BIGINT NOT NULL COMMENT '리소스 ID',
    PRIMARY KEY (role_id, resource_id),
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE,
    FOREIGN KEY (resource_id) REFERENCES resource(id) ON DELETE CASCADE
);