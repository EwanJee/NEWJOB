package com.newjob.consultant.entity.consultant;

import com.newjob.consultant.entity.career.CareerTestResult;
import com.newjob.consultant.entity.member.MemberConsultant;
import com.newjob.consultant.entity.mranderson.MrAndersonTestResult;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
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

    @Setter
    private int numberOfUsedCarerTests = 0;
    @Setter
    private int numberOfUsedMrAndersonTests = 0;

    public void setApproved(int approved) {
        isApproved = approved;
    }

    @Setter
    private int numberOfAvailableCareerTests = 0;
    @Setter
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
}
