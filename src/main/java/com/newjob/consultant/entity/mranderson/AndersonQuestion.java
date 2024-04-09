package com.newjob.consultant.entity.mranderson;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "anderson_questions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AndersonQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type1")
    private Long type1;
    @Column(name = "type2")
    private String type2;
    @Column(name = "questions_description")
    private String questions_description;
}
