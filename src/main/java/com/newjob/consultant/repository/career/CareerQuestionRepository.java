package com.newjob.consultant.repository.career;

import com.newjob.consultant.entity.career.CareerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerQuestionRepository extends JpaRepository<CareerQuestion, Long> {
}
