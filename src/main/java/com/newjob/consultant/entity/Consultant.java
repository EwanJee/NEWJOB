package com.newjob.consultant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    private String name;
    private String phoneNumber;
    private String password;
    private String company; //중경카 회사 소속

    public Consultant(String email, String name, String phoneNumber, String password, String company) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.company = company;
    }

    private int numberOfUsedCarerTests = 0;
    private int numberOfUsedMrAndersonTests = 0;

    private int numberOfAvailableCareerTests = 0;
    private int numberOfAvailableMrAndersonTests = 0;

    private int isApproved = 0;

    @OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CareerTestResult> careerTestResultList = new ArrayList<>();

    @OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MrAndersonTestResult> mrAndersonTestResultList = new ArrayList<>();

    @OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY)
    private List<MemberConsultant> memberConsultantList = new ArrayList<>();

    public void putCareerTestResult(CareerTestResult careerTestResult) {
        this.careerTestResultList.add(careerTestResult);
    }

    public void putMrAndersonTestResult(MrAndersonTestResult mrAndersonTestResult) {
        this.mrAndersonTestResultList.add(mrAndersonTestResult);
    }

    public void updateInitialForm(int anderson, int career, int approved) {
        this.numberOfAvailableMrAndersonTests = anderson;
        this.numberOfAvailableCareerTests = career;
        this.isApproved = approved;
    }


    public void updateUsedCareerTestsAndAvailableCareerTests(int numberOfUsedCarerTests, int numberOfAvailableCareerTests) {
        this.numberOfUsedCarerTests = numberOfUsedCarerTests;
        this.numberOfAvailableCareerTests = numberOfAvailableCareerTests;
    }

    public void updateUsedMrAndersonTestsAndAvailableMrAndersonTests(int numberOfUsedMrAndersonTests, int numberOfAvailableMrAndersonTests) {
        this.numberOfUsedMrAndersonTests = numberOfUsedMrAndersonTests;
        this.numberOfAvailableMrAndersonTests = numberOfAvailableMrAndersonTests;
    }
}
