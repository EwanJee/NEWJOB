package com.newjob.consultant.service;

import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.entity.MrAndersonTestResult;
import com.newjob.consultant.repository.JdbcMrAndersonTestRepository;
import com.newjob.consultant.repository.MrAndersonTestResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MrAndersonTestService {
    private final JdbcMrAndersonTestRepository jdbcMrAndersonTestRepository;
    private final MrAndersonTestResultRepository mrAndersonTestResultRepository;

    @Transactional
    public void join(MrAndersonTestResult mrAndersonTestResult){
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
    }
    public Optional<MrAndersonTestResult> findById(Long id){
        return mrAndersonTestResultRepository.findById(id);
    }
    @Transactional
    public void updateInfo(Long id, String job, String organization, String profession, String industry){
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        mrAndersonTestResult.setJob(job);
        mrAndersonTestResult.setOrganization2(organization);
        mrAndersonTestResult.setProfession(profession);
        mrAndersonTestResult.setIndustry(industry);
    }
    @Transactional
    public void updateScore1(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore1(i1-1);
        careerTestResult.setScore2(i2-1);
        careerTestResult.setScore3(i3-1);
        careerTestResult.setScore4(i4-1);
        careerTestResult.setScore5(i5-1);
        careerTestResult.setScore6(i6-1);
        careerTestResult.setScore7(i7-1);
        careerTestResult.setScore8(i8-1);
    }
    @Transactional
    public void updateScore2(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore9(i1-1);
        careerTestResult.setScore10(i2-1);
        careerTestResult.setScore11(i3-1);
        careerTestResult.setScore12(i4-1);
        careerTestResult.setScore13(i5-1);
        careerTestResult.setScore14(i6-1);
        careerTestResult.setScore15(i7-1);
        careerTestResult.setScore16(i8-1);
    }
    @Transactional
    public void updateScore3(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore17(i1-1);
        careerTestResult.setScore18(i2-1);
        careerTestResult.setScore19(i3-1);
        careerTestResult.setScore20(i4-1);
        careerTestResult.setScore21(i5-1);
        careerTestResult.setScore22(i6-1);
        careerTestResult.setScore23(i7-1);
        careerTestResult.setScore24(i8-1);
    }
    @Transactional
    public void updateScore4(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore25(i1-1);
        careerTestResult.setScore26(i2-1);
        careerTestResult.setScore27(i3-1);
        careerTestResult.setScore28(i4-1);
        careerTestResult.setScore29(i5-1);
        careerTestResult.setScore30(i6-1);
        careerTestResult.setScore31(i7-1);
        careerTestResult.setScore32(i8-1);
    }
    @Transactional
    public void updateScore5(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore33(i1-1);
        careerTestResult.setScore34(i2-1);
        careerTestResult.setScore35(i3-1);
        careerTestResult.setScore36(i4-1);
        careerTestResult.setScore37(i5-1);
        careerTestResult.setScore38(i6-1);
        careerTestResult.setScore39(i7-1);
        careerTestResult.setScore40(i8-1);
    }
    @Transactional
    public void updateScore6(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore41(i1-1);
        careerTestResult.setScore42(i2-1);
        careerTestResult.setScore43(i3-1);
        careerTestResult.setScore44(i4-1);
        careerTestResult.setScore45(i5-1);
        careerTestResult.setScore46(i6-1);
        careerTestResult.setScore47(i7-1);
        careerTestResult.setScore48(i8-1);
        careerTestResult.matchScoreGroup();
        careerTestResult.matchColorA();
        careerTestResult.matchColorB();
        careerTestResult.matchColorC();
        careerTestResult.matchColorD();
        careerTestResult.matchColorE();
        careerTestResult.matchColorF();
        getMyBlackBox(careerTestResult);

    }
    public List<String> getMrAndersonQuestions() {
        return jdbcMrAndersonTestRepository.getMrAndersonQuestions();
    }
    public void getMyBlackBox(MrAndersonTestResult mrAndersonTestResult){
        int levelA = fieldLevel(mrAndersonTestResult.getScoreAs());
        int levelB = fieldLevel(mrAndersonTestResult.getScoreBs());
        int levelC = fieldLevel(mrAndersonTestResult.getScoreCs());
        int levelD = fieldLevel(mrAndersonTestResult.getScoreDs());
        int levelE = fieldLevel(mrAndersonTestResult.getScoreEs());
        int levelF = fieldLevel(mrAndersonTestResult.getScoreFs());

        List<String> blackboxA = jdbcMrAndersonTestRepository.getAndersonBlackBoxA(levelA);
        List<String> blackboxB = jdbcMrAndersonTestRepository.getAndersonBlackBoxB(levelB);
        List<String> blackboxC = jdbcMrAndersonTestRepository.getAndersonBlackBoxC(levelC);
        List<String> blackboxD = jdbcMrAndersonTestRepository.getAndersonBlackBoxD(levelD);
        List<String> blackboxE = jdbcMrAndersonTestRepository.getAndersonBlackBoxE(levelE);
        List<String> blackboxF = jdbcMrAndersonTestRepository.getAndersonBlackBoxF(levelF);

        mrAndersonTestResult.setBlackBoxA_letters(blackboxA.get(0));
        mrAndersonTestResult.setBlackboxA_comment(blackboxA.get(1));

        mrAndersonTestResult.setBlackBoxB_letters(blackboxB.get(0));
        mrAndersonTestResult.setBlackboxB_comment(blackboxB.get(1));

        mrAndersonTestResult.setBlackBoxC_letters(blackboxC.get(0));
        mrAndersonTestResult.setBlackboxC_comment(blackboxC.get(1));

        mrAndersonTestResult.setBlackBoxD_letters(blackboxD.get(0));
        mrAndersonTestResult.setBlackboxD_comment(blackboxD.get(1));

        mrAndersonTestResult.setBlackBoxE_letters(blackboxE.get(0));
        mrAndersonTestResult.setBlackboxE_comment(blackboxE.get(1));

        mrAndersonTestResult.setBlackBoxF_letters(blackboxF.get(0));
        mrAndersonTestResult.setBlackboxF_comment(blackboxF.get(1));
    }
    private int fieldLevel(int score){
        if(score<11){
            return 1;
        }
        else if(score < 18){
            return 2;
        }
        else if(score < 22){
            return 3;
        }
        else if(score < 27){
            return 3;
        }
        else if(score < 33){
            return 5;
        }
        else{
            return 0;
        }
    }
}
