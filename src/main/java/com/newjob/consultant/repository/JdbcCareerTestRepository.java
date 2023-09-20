package com.newjob.consultant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcCareerTestRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCareerTestRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getCareerQuestions(){
        List<String> questions = new ArrayList<>();
        for(int number =1; number<=80; number++){
            questions.add(jdbcTemplate.queryForObject("SELECT career_questions_description FROM career_questions WHERE career_questions_number = ?",
                    String.class, number));
        }
        return questions;
    }

    public String getType(int number){
        return jdbcTemplate.queryForObject("SELECT career_questions_type FROM career_questions WHERE career_questions_number = ?",
                String.class, number);
    }
    public List<String> getQuestionsMappedByType(int number){
        List<String> questions = new ArrayList<>();
        for(int i=0; i<5; i++){
            questions.add(jdbcTemplate.queryForObject("SELECT career_questions_description FROM career_questions WHERE career_questions_number = ?",
                    String.class,number));
            number+=15;
        }
        return questions;
    }
}
