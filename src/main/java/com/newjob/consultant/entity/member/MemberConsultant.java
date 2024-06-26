package com.newjob.consultant.entity.member;

import com.newjob.consultant.entity.consultant.Consultant;
import com.newjob.consultant.entity.member.Member;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
public class MemberConsultant {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;
}
