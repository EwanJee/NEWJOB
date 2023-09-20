package com.newjob.consultant.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcAdminRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcAdminRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //password
    public Boolean checkById(String id){
        String password = jdbcTemplate.queryForObject("SELECT password FROM newjob_admin na WHERE id = ?", String.class, id);
        return password != null;
    }
}
