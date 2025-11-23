INSERT IGNORE INTO address (
    zipcode,
    address,
    address_detail
) VALUES (
    08810,
    "서울특별시 디지털로 52길 12",
    "101동 1201호"
);

INSERT IGNORE INTO account (
    uid,
    username,
    email,
    password,
    tel,
    gender,
    active,
    birth_date,
    country,
    university,
    work_type,
    address_id,
    created_at,
    updated_at
) VALUES (
    UNHEX(REPLACE(UUID(), '-', '')),  -- UUID (BINARY(16) 형식)
    '관리자',                         -- 이름
    'zvyg1023@naver.com',             -- 이메일
    '$2a$12$ECMg5WEsp8Hq/jDg1KQ3ZuJ/MMETqnPBYkfIRHAGMr5KpeMlpOEIy',  -- 비밀번호
    '010-1234-4567',                  -- 전화번호
    'MALE',                            -- 성별
    TRUE,                              -- 활성화
    '1997-10-23',                      -- 생년월일
    '대한민국',                         -- 국적
    '공주대학교',                        -- 대학
    'FULL_TIME',                        -- 근로 유형
    (SELECT id FROM address
         WHERE zipcode = 08810
           AND address = '서울특별시 디지털로 52길 12'
           AND address_detail = '101동 1201호'
         LIMIT 1),
    NOW(),
    NOW()
);

INSERT INTO account_role (account_id, role_id)
VALUES ((SELECT id FROM account WHERE email='zvyg1023@naver.com' LIMIT 1), 1);

INSERT INTO account_role (account_id, role_id)
VALUES ((SELECT id FROM account WHERE email='zvyg1023@naver.com' LIMIT 1), 2);

INSERT INTO account_role (account_id, role_id)
VALUES ((SELECT id FROM account WHERE email='zvyg1023@naver.com' LIMIT 1), 3);