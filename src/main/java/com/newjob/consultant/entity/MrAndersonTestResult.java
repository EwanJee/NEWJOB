package com.newjob.consultant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity @Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MrAndersonTestResult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String skey;

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

    public void setBlackBoxA_letters(String blackBoxA_letters) {
        this.blackBoxA_letters = blackBoxA_letters;
    }

    public void setBlackBoxB_letters(String blackBoxB_letters) {
        this.blackBoxB_letters = blackBoxB_letters;
    }

    public void setBlackBoxC_letters(String blackBoxC_letters) {
        this.blackBoxC_letters = blackBoxC_letters;
    }

    public void setBlackBoxD_letters(String blackBoxD_letters) {
        this.blackBoxD_letters = blackBoxD_letters;
    }

    public void setBlackBoxE_letters(String blackBoxE_letters) {
        this.blackBoxE_letters = blackBoxE_letters;
    }

    public void setBlackBoxF_letters(String blackBoxF_letters) {
        this.blackBoxF_letters = blackBoxF_letters;
    }

    public void setBlackboxA_comment(String blackboxA_comment) {
        this.blackboxA_comment = blackboxA_comment;
    }

    public void setBlackboxB_comment(String blackboxB_comment) {
        this.blackboxB_comment = blackboxB_comment;
    }

    public void setBlackboxC_comment(String blackboxC_comment) {
        this.blackboxC_comment = blackboxC_comment;
    }

    public void setBlackboxD_comment(String blackboxD_comment) {
        this.blackboxD_comment = blackboxD_comment;
    }

    public void setBlackboxE_comment(String blackboxE_comment) {
        this.blackboxE_comment = blackboxE_comment;
    }

    public void setBlackboxF_comment(String blackboxF_comment) {
        this.blackboxF_comment = blackboxF_comment;
    }

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
    @Column(updatable = false , nullable = true)
    private LocalDateTime createdAt;

    public void matchScoreGroup(){
        this.scoreAs = score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8;
        this.scoreBs = score9 + score10 + score11 + score12 + score13 + score14 + score15 + score16;
        this.scoreCs = score17 + score18 + score19 + score20 + score21 + score22 + score23 + score24;
        this.scoreDs = score25 + score26 + score27 + score28 + score29 + score30 + score31 + score32;
        this.scoreEs = score33 + score34 + score35 + score36 + score37 + score38 + score39 + score40;
        this.scoreFs = score41 + score42 + score43 + score44 + score45 + score46 + score47 + score48;
    }
    public void matchColorA(){
        if(this.scoreAs < 11) this.blackboxA_color = "RED";
        else if(this.scoreAs < 18) this.blackboxA_color = "RED";
        else if(this.scoreAs < 22) this.blackboxA_color = "RED";
        else if(this.scoreAs < 27) this.blackboxA_color = "BLUE";
        else if(this.scoreAs < 33) this.blackboxA_color = "BLUE";
    }
    public void matchColorB(){
        if(this.scoreBs < 11) this.blackboxB_color = "RED";
        else if(this.scoreBs < 18) this.blackboxB_color = "RED";
        else if(this.scoreBs < 22) this.blackboxB_color = "RED";
        else if(this.scoreBs < 27) this.blackboxB_color = "BLUE";
        else if(this.scoreBs < 33) this.blackboxB_color = "BLUE";
    }
    public void matchColorC(){
        if(this.scoreCs < 11) this.blackboxC_color = "RED";
        else if(this.scoreCs < 18) this.blackboxC_color = "RED";
        else if(this.scoreCs < 22) this.blackboxC_color = "BLUE";
        else if(this.scoreCs < 27) this.blackboxC_color = "BLUE";
        else if(this.scoreCs < 33) this.blackboxC_color = "SKYBLUE";
    }
    public void matchColorD(){
        if(this.scoreDs < 11) this.blackboxD_color = "RED";
        else if(this.scoreDs < 18) this.blackboxD_color = "RED";
        else if(this.scoreDs < 22) this.blackboxD_color = "BLUE";
        else if(this.scoreDs < 27) this.blackboxD_color = "BLUE";
        else if(this.scoreDs < 33) this.blackboxD_color = "SKYBLUE";
    }
    public void matchColorE(){
        if(this.scoreEs < 11) this.blackboxE_color = "RED";
        else if(this.scoreEs < 18) this.blackboxE_color = "RED";
        else if(this.scoreEs < 22) this.blackboxE_color = "BLUE";
        else if(this.scoreEs < 27) this.blackboxE_color = "BLUE";
        else if(this.scoreEs < 33) this.blackboxE_color = "SKYBLUE";
    }
    public void matchColorF(){
        if(this.scoreFs < 11) this.blackboxF_color = "RED";
        else if(this.scoreFs < 18) this.blackboxF_color = "RED";
        else if(this.scoreFs < 22) this.blackboxF_color = "BLUE";
        else if(this.scoreFs < 27) this.blackboxF_color = "BLUE";
        else if(this.scoreFs < 33) this.blackboxF_color = "SKYBLUE";
    }
}
