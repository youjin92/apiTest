package com.jyou.apiTest.auth.admin.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue
    @Column(name="admin_id")
    private Long id;
    private String loginId;
    private String password;
    private String nickname;
}