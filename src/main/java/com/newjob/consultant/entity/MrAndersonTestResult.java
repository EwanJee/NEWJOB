package com.newjob.consultant.entity;

import com.newjob.consultant.controller.MrAndersonTestResultForm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Entity
public class MrAndersonTestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
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

    public MrAndersonTestResult(String memberName, String consultantName, String organization, String consultantCompany) {
        this.memberName = memberName;
        this.consultantName = consultantName;
        this.organization = organization;
        this.consultantCompany = consultantCompany;
    }

    private String organization2;
    private String profession;
    private String industry;

    private int score1;
    private int score2;
    private int score3;
    private int score4;
    private int score5;
    private int score6;
    private int score7;
    private int score8;
    private int score9;
    private int score10;

    private int score11;
    private int score12;
    private int score13;
    private int score14;
    private int score15;
    private int score16;
    private int score17;
    private int score18;
    private int score19;
    private int score20;

    private int score21;
    private int score22;
    private int score23;
    private int score24;
    private int score25;
    private int score26;
    private int score27;
    private int score28;
    private int score29;
    private int score30;

    private int score31;
    private int score32;
    private int score33;
    private int score34;
    private int score35;
    private int score36;
    private int score37;
    private int score38;
    private int score39;
    private int score40;

    private int score41;
    private int score42;
    private int score43;
    private int score44;
    private int score45;
    private int score46;
    private int score47;
    private int score48;

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
        this.scoreAs = score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8;
        this.scoreBs = score9 + score10 + score11 + score12 + score13 + score14 + score15 + score16;
        this.scoreCs = score17 + score18 + score19 + score20 + score21 + score22 + score23 + score24;
        this.scoreDs = score25 + score26 + score27 + score28 + score29 + score30 + score31 + score32;
        this.scoreEs = score33 + score34 + score35 + score36 + score37 + score38 + score39 + score40;
        this.scoreFs = score41 + score42 + score43 + score44 + score45 + score46 + score47 + score48;
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

    public void updateInfo(MrAndersonTestResultForm mrAndersonTestResultForm) {
        this.organization2 = mrAndersonTestResultForm.getOrganization2();
        this.profession = mrAndersonTestResultForm.getProfession();
        this.industry = mrAndersonTestResultForm.getIndustry();
        this.job = mrAndersonTestResultForm.getJob();
    }

    public void updateScoreForRound1(MrAndersonTestResultForm mrAndersonTestResultForm) {
        this.score1 = mrAndersonTestResultForm.getScore1() - 1;
        this.score2 = mrAndersonTestResultForm.getScore2() - 1;
        this.score3 = mrAndersonTestResultForm.getScore3() - 1;
        this.score4 = mrAndersonTestResultForm.getScore4() - 1;
        this.score5 = mrAndersonTestResultForm.getScore5() - 1;
        this.score6 = mrAndersonTestResultForm.getScore6() - 1;
        this.score7 = mrAndersonTestResultForm.getScore7() - 1;
        this.score8 = mrAndersonTestResultForm.getScore8() - 1;
    }

    public void updateScoreForRound2(MrAndersonTestResultForm mrAndersonTestResultForm) {
        this.score9 = mrAndersonTestResultForm.getScore9() - 1;
        this.score10 = mrAndersonTestResultForm.getScore10() - 1;
        this.score11 = mrAndersonTestResultForm.getScore11() - 1;
        this.score12 = mrAndersonTestResultForm.getScore12() - 1;
        this.score13 = mrAndersonTestResultForm.getScore13() - 1;
        this.score14 = mrAndersonTestResultForm.getScore14() - 1;
        this.score15 = mrAndersonTestResultForm.getScore15() - 1;
        this.score16 = mrAndersonTestResultForm.getScore16() - 1;
    }

    public void updateScoreForRound3(MrAndersonTestResultForm mrAndersonTestResultForm) {
        this.score17 = mrAndersonTestResultForm.getScore17() - 1;
        this.score18 = mrAndersonTestResultForm.getScore18() - 1;
        this.score19 = mrAndersonTestResultForm.getScore19() - 1;
        this.score20 = mrAndersonTestResultForm.getScore20() - 1;
        this.score21 = mrAndersonTestResultForm.getScore21() - 1;
        this.score22 = mrAndersonTestResultForm.getScore22() - 1;
        this.score23 = mrAndersonTestResultForm.getScore23() - 1;
        this.score24 = mrAndersonTestResultForm.getScore24() - 1;
    }

    public void updateScoreForRound4(MrAndersonTestResultForm mrAndersonTestResultForm) {
        this.score25 = mrAndersonTestResultForm.getScore25() - 1;
        this.score26 = mrAndersonTestResultForm.getScore26() - 1;
        this.score27 = mrAndersonTestResultForm.getScore27() - 1;
        this.score28 = mrAndersonTestResultForm.getScore28() - 1;
        this.score29 = mrAndersonTestResultForm.getScore29() - 1;
        this.score30 = mrAndersonTestResultForm.getScore30() - 1;
        this.score31 = mrAndersonTestResultForm.getScore31() - 1;
        this.score32 = mrAndersonTestResultForm.getScore32() - 1;
    }

    public void updateScoreForRound5(MrAndersonTestResultForm mrAndersonTestResultForm) {
        this.score33 = mrAndersonTestResultForm.getScore33() - 1;
        this.score34 = mrAndersonTestResultForm.getScore34() - 1;
        this.score35 = mrAndersonTestResultForm.getScore35() - 1;
        this.score36 = mrAndersonTestResultForm.getScore36() - 1;
        this.score37 = mrAndersonTestResultForm.getScore37() - 1;
        this.score38 = mrAndersonTestResultForm.getScore38() - 1;
        this.score39 = mrAndersonTestResultForm.getScore39() - 1;
        this.score40 = mrAndersonTestResultForm.getScore40() - 1;
    }

    public void updateScoreForRound6(MrAndersonTestResultForm mrAndersonTestResultForm) {
        this.score41 = mrAndersonTestResultForm.getScore41() - 1;
        this.score42 = mrAndersonTestResultForm.getScore42() - 1;
        this.score43 = mrAndersonTestResultForm.getScore43() - 1;
        this.score44 = mrAndersonTestResultForm.getScore44() - 1;
        this.score45 = mrAndersonTestResultForm.getScore45() - 1;
        this.score46 = mrAndersonTestResultForm.getScore46() - 1;
        this.score47 = mrAndersonTestResultForm.getScore47() - 1;
        this.score48 = mrAndersonTestResultForm.getScore48() - 1;
    }

    public void updateBlackBox(AndersonBlackbox blackboxA, AndersonBlackbox blackboxB, AndersonBlackbox blackboxC, AndersonBlackbox blackboxD, AndersonBlackbox blackboxE, AndersonBlackbox blackboxF) {
        this.blackBoxA_letters = blackboxA.getType();
        this.blackBoxB_letters = blackboxB.getType();
        this.blackBoxC_letters = blackboxC.getType();
        this.blackBoxD_letters = blackboxD.getType();
        this.blackBoxE_letters = blackboxE.getType();
        this.blackBoxF_letters = blackboxF.getType();
        this.blackboxA_comment = blackboxA.getFieldA();
        this.blackboxB_comment = blackboxB.getFieldB();
        this.blackboxC_comment = blackboxC.getFieldC();
        this.blackboxD_comment = blackboxD.getFieldD();
        this.blackboxE_comment = blackboxE.getFieldE();
        this.blackboxF_comment = blackboxF.getFieldF();
    }

}
