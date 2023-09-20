package com.newjob.consultant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity @Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class CareerTestResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String memberName;
    private String consultantName;
    private String organization; //소속
    private String consultantCompany; //중경카 업체 이름
    private String skey;

    private String careerLocation;

    public CareerTestResult(String memberName, String consultantName, String organization, String consultantCompany) {
        this.memberName = memberName;
        this.consultantName = consultantName;
        this.organization = organization;
        this.consultantCompany = consultantCompany;
    }

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
    private int score49;
    private int score50;

    private int score51;
    private int score52;
    private int score53;
    private int score54;
    private int score55;
    private int score56;
    private int score57;
    private int score58;
    private int score59;
    private int score60;

    private int score61;
    private int score62;
    private int score63;
    private int score64;
    private int score65;
    private int score66;
    private int score67;
    private int score68;
    private int score69;
    private int score70;

    private int score71;
    private int score72;
    private int score73;
    private int score74;
    private int score75;
    private int score76;
    private int score77;
    private int score78;
    private int score79;
    private int score80;

    private int scoreO;
    private int scoreD;
    private int scoreI;

    private int scoreE;
    private int scoreL;
    private int scoreN;

    private int scoreF;
    private int scoreA;
    private int scoreJ;

    private int scoreB;
    private int scoreM;
    private int scoreG;

    private int scoreH;
    private int scoreC;
    private int scoreK;

    private int scoreW;

    private int scoreCharacter;
    private int scoreConnection;
    private int scoreCondition;
    private int scoreChallenge;
    private int scoreControl;

    private int scoreAbility;
    private int scoreNetworkPower;
    private int scoreMoveOn;

    @CreatedDate
    @Column(updatable = false , nullable = true)
    private LocalDateTime createdAt;

    public CareerTestResult(int score1, int score2, int score3, int score4, int score5, int score6, int score7, int score8, int score9, int score10, int score11, int score12, int score13, int score14, int score15, int score16, int score17, int score18, int score19, int score20, int score21, int score22, int score23, int score24, int score25, int score26, int score27, int score28, int score29, int score30, int score31, int score32, int score33, int score34, int score35, int score36, int score37, int score38, int score39, int score40, int score41, int score42, int score43, int score44, int score45, int score46, int score47, int score48, int score49, int score50, int score51, int score52, int score53, int score54, int score55, int score56, int score57, int score58, int score59, int score60, int score61, int score62, int score63, int score64, int score65, int score66, int score67, int score68, int score69, int score70, int score71, int score72, int score73, int score74, int score75, int score76, int score77, int score78, int score79, int score80) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
        this.score7 = score7;
        this.score8 = score8;
        this.score9 = score9;
        this.score10 = score10;
        this.score11 = score11;
        this.score12 = score12;
        this.score13 = score13;
        this.score14 = score14;
        this.score15 = score15;
        this.score16 = score16;
        this.score17 = score17;
        this.score18 = score18;
        this.score19 = score19;
        this.score20 = score20;
        this.score21 = score21;
        this.score22 = score22;
        this.score23 = score23;
        this.score24 = score24;
        this.score25 = score25;
        this.score26 = score26;
        this.score27 = score27;
        this.score28 = score28;
        this.score29 = score29;
        this.score30 = score30;
        this.score31 = score31;
        this.score32 = score32;
        this.score33 = score33;
        this.score34 = score34;
        this.score35 = score35;
        this.score36 = score36;
        this.score37 = score37;
        this.score38 = score38;
        this.score39 = score39;
        this.score40 = score40;
        this.score41 = score41;
        this.score42 = score42;
        this.score43 = score43;
        this.score44 = score44;
        this.score45 = score45;
        this.score46 = score46;
        this.score47 = score47;
        this.score48 = score48;
        this.score49 = score49;
        this.score50 = score50;
        this.score51 = score51;
        this.score52 = score52;
        this.score53 = score53;
        this.score54 = score54;
        this.score55 = score55;
        this.score56 = score56;
        this.score57 = score57;
        this.score58 = score58;
        this.score59 = score59;
        this.score60 = score60;
        this.score61 = score61;
        this.score62 = score62;
        this.score63 = score63;
        this.score64 = score64;
        this.score65 = score65;
        this.score66 = score66;
        this.score67 = score67;
        this.score68 = score68;
        this.score69 = score69;
        this.score70 = score70;
        this.score71 = score71;
        this.score72 = score72;
        this.score73 = score73;
        this.score74 = score74;
        this.score75 = score75;
        this.score76 = score76;
        this.score77 = score77;
        this.score78 = score78;
        this.score79 = score79;
        this.score80 = score80;
    }

    public CareerTestResult() {

    }

    public void matchingScore(){
        this.scoreO = score1 + score16 + score31 + score46 + score61;
        this.scoreD = score2 + score17 + score32 + score47 + score62;
        this.scoreI = score3 + score18 + score33 + score48 + score63;

        this.scoreE = score4 + score19 + score34 + score49 + score64;
        this.scoreL = score5 + score20 + score35 + score50 + score65;
        this.scoreN = score6 + score21 + score36 + score51 + score66;

        this.scoreF = score7 + score22 + score37 + score52 + score67;
        this.scoreA = score8 + score23 + score38 + score53 + score68;
        this.scoreJ = score9 + score24 + score39 + score54 + score69;

        this.scoreB = score10 + score25 + score40 + score55 + score70;
        this.scoreM = score11 + score26 + score41 + score56 + score71;
        this.scoreG = score12 + score27 + score42 + score57 + score72;

        this.scoreH = score13 + score28 + score43 + score58 + score73;
        this.scoreC = score14 + score29 + score44 + score59 + score74;
        this.scoreK = score15 + score30 + score45 + score60 + score75;

        this.scoreW = score76 + score77 + score78 + score79 + score80;

        this.scoreCharacter = scoreA + scoreB + scoreC;
        this.scoreConnection = scoreD + scoreE + scoreF;
        this.scoreCondition = scoreG + scoreH + scoreI;
        this.scoreChallenge = scoreJ + scoreK + scoreL;
        this.scoreControl = scoreM + scoreN + scoreO;

        this.scoreAbility = score25 * 2 + score34 * 2 + score40 * 2 + score48 * 3
                + score63 * 3 + score70 * 2 + score2 + score13 + score38 + score41
                + score43 + score57 + score75 + scoreW;

        this.scoreNetworkPower = score19*2 + score37*2 + score41*2 + score49*2 + score2
                + score7 +score11 + score17 + score26 + score28 + score43 + score56
                + score60 + score62 + score69 + score71 + score74 + score75;

        this.scoreMoveOn = (scoreAbility + scoreNetworkPower)/3 + score19 + score24
                + score25 + score26 + score28 + score48 + score63 + score70 +score75;
    }
}
