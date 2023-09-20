package com.newjob.consultant.repository;

import com.newjob.consultant.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    Optional<Consultant> findBySkeyAndName(String skey, String Name);
    Optional<Consultant> findByEmail(String email);
    Optional<Consultant> findByEmailAndPassword(String email, String password);
}