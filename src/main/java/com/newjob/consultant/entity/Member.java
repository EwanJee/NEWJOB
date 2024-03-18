package com.newjob.consultant.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String phoneNumber;
    private String consultantName;
    private String organization; //소속
    private String consultantCompany; //중경카 업체 이름
    private String skey;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberConsultant> memberConsultantList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<CareerTestResult> careerTestResultList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MrAndersonTestResult> mrAndersonTestResultList = new ArrayList<>();

}
