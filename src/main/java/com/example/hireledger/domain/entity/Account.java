package com.example.hireledger.domain.entity;

import com.example.hireledger.domain.enums.Gender;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private UUID uid;
    private String username;
    private String password;
    private String email;
    private String tel;
    private Gender gender;
    private boolean active;
}
