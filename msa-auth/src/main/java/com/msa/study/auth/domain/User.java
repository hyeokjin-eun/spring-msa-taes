package com.msa.study.auth.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_USER")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 20, unique = true, nullable = false)
    private String userName;

    @Column(length = 400, nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false)
    private int userType;

    @Column(nullable = false)
    private Date date;
}
