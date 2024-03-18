package com.newjob.consultant.repository;

import com.newjob.consultant.entity.AndersonQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndersonQuestionsRepository extends JpaRepository<AndersonQuestion, Long> {
}
