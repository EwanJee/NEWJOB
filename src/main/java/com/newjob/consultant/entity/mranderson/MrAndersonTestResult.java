package com.newjob.consultant.entity.mranderson;

import com.newjob.consultant.entity.member.Member;
import com.newjob.consultant.entity.consultant.Consultant;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
public class MrAndersonTestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    public String phoneNumber;

    private String memberName;
    private String consultantName;
    private String organization; //소속
    private String consultantCompany; //중경카 업체 이름

    private String job;

    private String organization2;
    private String profession;
    private String industry;

    @ElementCollection // @ElementCollection을 사용하면, 해당 필드는 별도의 테이블로 생성된다. 최대 사이즈 48
    private final List<Integer> questionScores = new ArrayList<>();

    private int scoreAs;
    private int scoreBs;
    private int scoreCs;
    private int scoreDs;
    private int scoreEs;
    private int scoreFs;

    private String blackboxA_color;
    private String blackboxB_color;
    private String blackboxC_color;
    private String blackboxD_color;
    private String blackboxE_color;
    private String blackboxF_color;

    private String blackBoxA_letters;
    private String blackBoxB_letters;
    private String blackBoxC_letters;

    private String blackBoxD_letters;
    private String blackBoxE_letters;
    private String blackBoxF_letters;

    private String blackboxA_comment;
    private String blackboxB_comment;
    private String blackboxC_comment;
    private String blackboxD_comment;
    private String blackboxE_comment;
    private String blackboxF_comment;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public void matchScoreGroup() {
        this.scoreAs = questionScores.get(0) + questionScores.get(1) + questionScores.get(2) + questionScores.get(3) + questionScores.get(4) + questionScores.get(5) + questionScores.get(6) + questionScores.get(7);
        this.scoreBs = questionScores.get(8) + questionScores.get(9) + questionScores.get(10) + questionScores.get(11) + questionScores.get(12) + questionScores.get(13) + questionScores.get(14) + questionScores.get(15);
        this.scoreCs = questionScores.get(16) + questionScores.get(17) + questionScores.get(18) + questionScores.get(19) + questionScores.get(20) + questionScores.get(21) + questionScores.get(22) + questionScores.get(23);
        this.scoreDs = questionScores.get(24) + questionScores.get(25) + questionScores.get(26) + questionScores.get(27) + questionScores.get(28) + questionScores.get(29) + questionScores.get(30) + questionScores.get(31);
        this.scoreEs = questionScores.get(32) + questionScores.get(33) + questionScores.get(34) + questionScores.get(35) + questionScores.get(36) + questionScores.get(37) + questionScores.get(38) + questionScores.get(39);
        this.scoreFs = questionScores.get(40) + questionScores.get(41) + questionScores.get(42) + questionScores.get(43) + questionScores.get(44) + questionScores.get(45) + questionScores.get(46) + questionScores.get(47);
    }

    public void matchColorA() {
        if (this.scoreAs < 11) this.blackboxA_color = "RED";
        else if (this.scoreAs < 18) this.blackboxA_color = "RED";
        else if (this.scoreAs < 22) this.blackboxA_color = "RED";
        else if (this.scoreAs < 27) this.blackboxA_color = "BLUE";
        else if (this.scoreAs < 33) this.blackboxA_color = "BLUE";
    }

    public void matchColorB() {
        if (this.scoreBs < 11) this.blackboxB_color = "RED";
        else if (this.scoreBs < 18) this.blackboxB_color = "RED";
        else if (this.scoreBs < 22) this.blackboxB_color = "RED";
        else if (this.scoreBs < 27) this.blackboxB_color = "BLUE";
        else if (this.scoreBs < 33) this.blackboxB_color = "BLUE";
    }

    public void matchColorC() {
        if (this.scoreCs < 11) this.blackboxC_color = "RED";
        else if (this.scoreCs < 18) this.blackboxC_color = "RED";
        else if (this.scoreCs < 22) this.blackboxC_color = "BLUE";
        else if (this.scoreCs < 27) this.blackboxC_color = "BLUE";
        else if (this.scoreCs < 33) this.blackboxC_color = "SKYBLUE";
    }

    public void matchColorD() {
        if (this.scoreDs < 11) this.blackboxD_color = "RED";
        else if (this.scoreDs < 18) this.blackboxD_color = "RED";
        else if (this.scoreDs < 22) this.blackboxD_color = "BLUE";
        else if (this.scoreDs < 27) this.blackboxD_color = "BLUE";
        else if (this.scoreDs < 33) this.blackboxD_color = "SKYBLUE";
    }

    public void matchColorE() {
        if (this.scoreEs < 11) this.blackboxE_color = "RED";
        else if (this.scoreEs < 18) this.blackboxE_color = "RED";
        else if (this.scoreEs < 22) this.blackboxE_color = "BLUE";
        else if (this.scoreEs < 27) this.blackboxE_color = "BLUE";
        else if (this.scoreEs < 33) this.blackboxE_color = "SKYBLUE";
    }

    public void matchColorF() {
        if (this.scoreFs < 11) this.blackboxF_color = "RED";
        else if (this.scoreFs < 18) this.blackboxF_color = "RED";
        else if (this.scoreFs < 22) this.blackboxF_color = "BLUE";
        else if (this.scoreFs < 27) this.blackboxF_color = "BLUE";
        else if (this.scoreFs < 33) this.blackboxF_color = "SKYBLUE";
    }

    public void updateConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public void updateInfo(String job, String organization, String profession, String industry) {
        this.job = job;
        this.organization2 = organization;
        this.profession = profession;
        this.industry = industry;
    }
}
