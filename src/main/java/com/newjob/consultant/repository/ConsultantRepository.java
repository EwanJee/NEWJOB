package com.newjob.consultant.repository;

import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.entity.MrAndersonTestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    Optional<Consultant> findBySkeyAndName(String skey, String Name);
    Optional<Consultant> findByEmail(String email);
    Optional<Consultant> findByEmailAndPassword(String email, String password);

    @Query("SELECT ctr from CareerTestResult ctr inner join Consultant c ON c.id = ctr.consultant.id")
    List<CareerTestResult> getCareerList();

    @Query("SELECT mtr from MrAndersonTestResult mtr inner join Consultant c ON c.id = mtr.consultant.id")
    List<MrAndersonTestResult> getMrAndersonList();
}