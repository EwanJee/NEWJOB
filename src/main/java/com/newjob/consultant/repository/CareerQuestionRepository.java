package com.newjob.consultant.repository;

import com.newjob.consultant.entity.CareerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerQuestionRepository extends JpaRepository<CareerQuestion, Long> {
}
