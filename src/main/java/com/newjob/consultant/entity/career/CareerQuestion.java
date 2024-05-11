package com.newjob.consultant.entity.career;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "career_questions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CareerQuestion {
    @Id
    @Column(name = "career_questions_number")
    private Long careerQuestionsNumber;
    @Column(name = "career_questions_description")
    private String careerQuestionsDescription;
    @Column(name = "career_questions_type")
    private String careerQuestionsType;
}
