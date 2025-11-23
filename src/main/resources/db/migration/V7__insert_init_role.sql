INSERT IGNORE INTO role (role_type, description)
VALUES
('USER', '일반 사용자 권한'),
('MANAGER', '특정 권한을 가진 관리자'),
('ADMIN', '모든 관리 권한을 가진 관리자');