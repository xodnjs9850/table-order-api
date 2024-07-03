package com.tableOrder.table_order.user.entity;

import com.tableOrder.table_order.user.model.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String encryptedPassword;

    @Column
    private String name;

    @Column
    private UserRole userRole;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    private String refreshToken;

    @Column
    private LocalDateTime lastTokenIssuedAt;

}
