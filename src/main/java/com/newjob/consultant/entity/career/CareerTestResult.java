package com.newjob.consultant.entity.career;

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
@EntityListeners(AuditingEntityListener.class) // JPA Auditing을 사용하기 위해 EntityListeners를 추가한다.
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Builder
public class CareerTestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private String phoneNumber;

    private String careerLocation;

    @ElementCollection // @ElementCollection을 사용하면, 해당 필드는 별도의 테이블로 생성된다.
    private List<Integer> questionScores = new ArrayList<>();

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
    @Column(updatable = false, nullable = true)
    private LocalDateTime createdAt;
    public void updateCareerLocation(String careerLocation) {
        this.careerLocation = careerLocation;
    }

    public void matchingScore() {
        this.scoreO = questionScores.get(0) + questionScores.get(15) + questionScores.get(30) + questionScores.get(45) + questionScores.get(60); // What
        this.scoreD = questionScores.get(1) + questionScores.get(16) + questionScores.get(31) + questionScores.get(46) + questionScores.get(61); // How
        this.scoreI = questionScores.get(2) + questionScores.get(17) + questionScores.get(32) + questionScores.get(47) + questionScores.get(62); // Why

        this.scoreE = questionScores.get(3) + questionScores.get(18) + questionScores.get(33) + questionScores.get(48) + questionScores.get(63); // 성과/평가
        this.scoreL = questionScores.get(4) + questionScores.get(19) + questionScores.get(34) + questionScores.get(49) + questionScores.get(64); // 네트워크
        this.scoreN = questionScores.get(5) + questionScores.get(20) + questionScores.get(35) + questionScores.get(50) + questionScores.get(65); // 팀웍/동료

        this.scoreF = questionScores.get(6) + questionScores.get(21) + questionScores.get(36) + questionScores.get(51) + questionScores.get(66); // 조직
        this.scoreA = questionScores.get(7) + questionScores.get(22) + questionScores.get(37) + questionScores.get(52) + questionScores.get(67); // 업계
        this.scoreJ = questionScores.get(8) + questionScores.get(23) + questionScores.get(38) + questionScores.get(53) + questionScores.get(68); // 전문분야

        this.scoreB = questionScores.get(9) + questionScores.get(24) + questionScores.get(39) + questionScores.get(54) + questionScores.get(69); // 영역확장
        this.scoreM = questionScores.get(10) + questionScores.get(25) + questionScores.get(40) + questionScores.get(55) + questionScores.get(70); // 영역개발
        this.scoreG = questionScores.get(11) + questionScores.get(26) + questionScores.get(41) + questionScores.get(56) + questionScores.get(71); // 업무재조성

        this.scoreH = questionScores.get(12) + questionScores.get(27) + questionScores.get(42) + questionScores.get(57) + questionScores.get(72); // 지원개발
        this.scoreC = questionScores.get(13) + questionScores.get(28) + questionScores.get(43) + questionScores.get(58) + questionScores.get(73); // 학습계획
        this.scoreK = questionScores.get(14) + questionScores.get(29) + questionScores.get(44) + questionScores.get(59) + questionScores.get(74); // 실천

        this.scoreW = questionScores.get(75) + questionScores.get(76) + questionScores.get(77) + questionScores.get(78) + questionScores.get(79); // 월드지수

        this.scoreCharacter = scoreA + scoreB + scoreC;
        this.scoreConnection = scoreD + scoreE + scoreF;
        this.scoreCondition = scoreG + scoreH + scoreI;
        this.scoreChallenge = scoreJ + scoreK + scoreL;
        this.scoreControl = scoreM + scoreN + scoreO;

        this.scoreAbility = questionScores.get(24) * 2 + questionScores.get(33) * 2 + questionScores.get(39) * 2 + questionScores.get(47) * 3
                + questionScores.get(62) * 3 + questionScores.get(69) * 2 + questionScores.get(1) + questionScores.get(12) + questionScores.get(37) + questionScores.get(40)
                + questionScores.get(42) + questionScores.get(56) + questionScores.get(74) + questionScores.get(75) + questionScores.get(79);

        this.scoreNetworkPower = questionScores.get(18) * 2 + questionScores.get(36) * 2 + questionScores.get(40) * 2 + questionScores.get(48) * 2 + questionScores.get(1)
                + questionScores.get(6) + questionScores.get(10) + questionScores.get(16) + questionScores.get(25) + questionScores.get(27) + questionScores.get(42) + questionScores.get(55)
                + questionScores.get(59) + questionScores.get(61) + questionScores.get(68) + questionScores.get(70) + questionScores.get(73) + questionScores.get(74);

        this.scoreMoveOn = (scoreAbility + scoreNetworkPower) / 3 + questionScores.get(18) + questionScores.get(23)
                + questionScores.get(24) + questionScores.get(25) + questionScores.get(27) + questionScores.get(47) + questionScores.get(62) + questionScores.get(69) + questionScores.get(74);
    }
}
