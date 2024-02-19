package com.newjob.consultant.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@Table(name = "newjob_admin")
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADMIN_ID")
    private Long id;
    @Column(name = "id")
    private String adminId;
    @Column(name = "password")
    private String password;
}
