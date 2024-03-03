package com.newjob.consultant.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "anderson_questions")
public class AndersonQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type1")
    private Long type1;
    @Column(name = "type2")
    private String type2;
    @Column(name = "questions_description")
    private String questions_description;
}
