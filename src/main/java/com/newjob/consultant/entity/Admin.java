package com.newjob.consultant.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "newjob_admin")
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequence")
    private Long seq;
    @Column(name = "id")
    private String id;
    @Column(name = "password")
    private String password;

}
