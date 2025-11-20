package com.example.hireledger.domain.entity;

import com.example.hireledger.domain.enums.Gender;
import com.example.hireledger.domain.enums.WorkType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDate birthDate;
    private String country;
    private String faceUrl;
    private String university;
    private WorkType workType;
    private Long addressId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;
}
