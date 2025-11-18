-- 계정 테이블
CREATE TABLE account (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         uid BINARY(16) NOT NULL UNIQUE ,
                         username VARCHAR(100) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE ,
                         tel VARCHAR(100),
                         gender ENUM('MALE','FEMALE'),
                         active BOOLEAN DEFAULT TRUE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         deleted_at TIMESTAMP DEFAULT NULL
);

-- 권한(Role)
CREATE TABLE role (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      role_name VARCHAR(50) NOT NULL UNIQUE,   -- ex) ROLE_ADMIN, ROLE_USER
                      description VARCHAR(200)
);

-- 리소스(Resource)
CREATE TABLE resource (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          resource_name VARCHAR(100) NOT NULL,         -- ex) 'Admin Dashboard'
                          http_method VARCHAR(20),            -- ex) 'GET', 'POST'
                          order_num INT,
                          resource_type VARCHAR(200)
);

-- 계정-권한 매핑
CREATE TABLE account_role (
                              account_id BIGINT NOT NULL,
                              role_id BIGINT NOT NULL,
                              PRIMARY KEY (account_id, role_id),
                              FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE,
                              FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
);

-- 권한-리소스 매핑
CREATE TABLE role_resource (
                               role_id BIGINT NOT NULL,
                               resource_id BIGINT NOT NULL,
                               PRIMARY KEY (role_id, resource_id),
                               FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE,
                               FOREIGN KEY (resource_id) REFERENCES resource(id) ON DELETE CASCADE
);
