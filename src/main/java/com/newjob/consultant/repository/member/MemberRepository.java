package com.newjob.consultant.repository.member;

import com.newjob.consultant.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
