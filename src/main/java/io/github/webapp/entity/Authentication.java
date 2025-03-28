package io.github.webapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "authentications") // Entity 이름과 table 이름이 다르다면 명시해야 함
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    @Id // 기본키
    @Column(length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role authority;
}
