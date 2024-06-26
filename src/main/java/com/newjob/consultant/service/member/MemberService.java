package com.newjob.consultant.service.member;

import com.newjob.consultant.entity.member.Member;
import com.newjob.consultant.repository.member.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void join(Member member){
        memberRepository.save(member);
    }
}
