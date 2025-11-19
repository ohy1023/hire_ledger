INSERT IGNORE INTO resource (resource_name, http_method, order_num, resource_type)
VALUES
('/login', 'POST', 0, 'URL'),
('/user/**', 'GET', 1, 'URL'),
('/manager/**', 'GET', 2, 'URL'),
('/admin/**', 'GET', 3, 'URL'),
('/admin/**', 'POST', 4, 'URL');
