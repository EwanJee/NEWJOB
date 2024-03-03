package com.newjob.consultant.repository;

import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
