package com.newjob.consultant.repository.consultant;

import com.newjob.consultant.entity.consultant.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Optional<Consultant> findByEmail(String email);

    Optional<Consultant> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
