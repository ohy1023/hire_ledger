INSERT IGNORE INTO resource (resource_name, http_method, order_num, resource_type)
VALUES
('/login', 'POST', 1, 'URL'),
('/register', 'POST', 2, 'URL'),
('/user/**', 'GET', 3, 'URL'),
('/admin/**', 'GET', 4, 'URL'),
('/manager/**', 'GET', 5, 'URL');