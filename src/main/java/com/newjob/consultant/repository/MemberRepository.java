package com.newjob.consultant.repository;

import com.newjob.consultant.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
