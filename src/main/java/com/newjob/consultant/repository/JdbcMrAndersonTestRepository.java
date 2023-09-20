package com.newjob.consultant.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcMrAndersonTestRepository {
    private final JdbcTemplate jdbcTemplate;
    public JdbcMrAndersonTestRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getMrAndersonQuestions(){
        List<String> questions = new ArrayList<>();
        for(int number =1; number<=48; number++){
            questions.add(jdbcTemplate.queryForObject("SELECT questions_description FROM anderson_questions WHERE type1 = ?",
                    String.class, String.valueOf(number)));
        }
        return questions;
    }
    public List<String> getAndersonBlackBoxA(int number){
        List<String> blackbox = new ArrayList<>();
            blackbox.add(jdbcTemplate.queryForObject("SELECT type FROM anderson_blackbox WHERE b_number = ?",
                    String.class, number));
            blackbox.add(jdbcTemplate.queryForObject("SELECT field_a FROM anderson_blackbox WHERE b_number = ?",
                    String.class, number));
        return blackbox;
    }
    public List<String> getAndersonBlackBoxB(int number){
        List<String> blackbox = new ArrayList<>();
        blackbox.add(jdbcTemplate.queryForObject("SELECT type FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        blackbox.add(jdbcTemplate.queryForObject("SELECT field_b FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        return blackbox;
    }
    public List<String> getAndersonBlackBoxC(int number){
        List<String> blackbox = new ArrayList<>();
        blackbox.add(jdbcTemplate.queryForObject("SELECT type FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        blackbox.add(jdbcTemplate.queryForObject("SELECT field_c FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        return blackbox;
    }
    public List<String> getAndersonBlackBoxD(int number){
        List<String> blackbox = new ArrayList<>();
        blackbox.add(jdbcTemplate.queryForObject("SELECT type FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        blackbox.add(jdbcTemplate.queryForObject("SELECT field_d FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        return blackbox;
    }
    public List<String> getAndersonBlackBoxE(int number){
        List<String> blackbox = new ArrayList<>();
        blackbox.add(jdbcTemplate.queryForObject("SELECT type FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        blackbox.add(jdbcTemplate.queryForObject("SELECT field_e FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        return blackbox;
    }
    public List<String> getAndersonBlackBoxF(int number){
        List<String> blackbox = new ArrayList<>();
        blackbox.add(jdbcTemplate.queryForObject("SELECT type FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        blackbox.add(jdbcTemplate.queryForObject("SELECT field_f FROM anderson_blackbox WHERE b_number = ?",
                String.class, number));
        return blackbox;
    }
}
