-- ROLE_USER 접근 가능한 리소스
INSERT IGNORE INTO role_resource (role_id, resource_id)
SELECT r.id, res.id
FROM role r, resource res
WHERE r.role_name = 'ROLE_USER' AND res.resource_name = '/user/**';

-- ROLE_MANAGER 접근 가능한 리소스
INSERT IGNORE INTO role_resource (role_id, resource_id)
SELECT r.id, res.id
FROM role r, resource res
WHERE r.role_name = 'ROLE_MANAGER' AND res.resource_name = '/manager/**';

-- ROLE_ADMIN 접근 가능한 리소스
INSERT IGNORE INTO role_resource (role_id, resource_id)
SELECT r.id, res.id
FROM role r, resource res
WHERE r.role_name = 'ROLE_ADMIN' AND res.resource_name IN ('/admin/**', '/manager/**', '/user/**');