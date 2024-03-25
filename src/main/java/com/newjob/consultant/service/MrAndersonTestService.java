package com.newjob.consultant.service;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
import com.newjob.consultant.entity.AndersonBlackbox;
import com.newjob.consultant.entity.MrAndersonTestResult;
import com.newjob.consultant.repository.AndersonBlackboxRepository;
import com.newjob.consultant.entity.AndersonQuestion;
import com.newjob.consultant.repository.AndersonQuestionsRepository;
import com.newjob.consultant.repository.MrAndersonTestResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MrAndersonTestService {
    private final MrAndersonTestResultRepository mrAndersonTestResultRepository;
    private final AndersonBlackboxRepository andersonBlackboxRepository;
    private final AndersonQuestionsRepository andersonQuestionsRepository;

    @Transactional
    public void join(MrAndersonTestResult mrAndersonTestResult) {
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
    }

    public Optional<MrAndersonTestResult> findById(Long id) {
        return mrAndersonTestResultRepository.findById(id);
    }

    @Transactional
    public void updateInfo(Long id, String job, String organization, String profession, String industry) {
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        mrAndersonTestResult.setJob(job);
        mrAndersonTestResult.setOrganization2(organization);
        mrAndersonTestResult.setProfession(profession);
        mrAndersonTestResult.setIndustry(industry);
    }

    @Transactional
    public void updateScore1(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.setScore1(i1 - 1);
        careerTestResult.setScore2(i2 - 1);
        careerTestResult.setScore3(i3 - 1);
        careerTestResult.setScore4(i4 - 1);
        careerTestResult.setScore5(i5 - 1);
        careerTestResult.setScore6(i6 - 1);
        careerTestResult.setScore7(i7 - 1);
        careerTestResult.setScore8(i8 - 1);
    }

    @Transactional
    public void updateScore2(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.setScore9(i1 - 1);
        careerTestResult.setScore10(i2 - 1);
        careerTestResult.setScore11(i3 - 1);
        careerTestResult.setScore12(i4 - 1);
        careerTestResult.setScore13(i5 - 1);
        careerTestResult.setScore14(i6 - 1);
        careerTestResult.setScore15(i7 - 1);
        careerTestResult.setScore16(i8 - 1);
    }

    @Transactional
    public void updateScore3(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.setScore17(i1 - 1);
        careerTestResult.setScore18(i2 - 1);
        careerTestResult.setScore19(i3 - 1);
        careerTestResult.setScore20(i4 - 1);
        careerTestResult.setScore21(i5 - 1);
        careerTestResult.setScore22(i6 - 1);
        careerTestResult.setScore23(i7 - 1);
        careerTestResult.setScore24(i8 - 1);
    }

    @Transactional
    public void updateScore4(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.setScore25(i1 - 1);
        careerTestResult.setScore26(i2 - 1);
        careerTestResult.setScore27(i3 - 1);
        careerTestResult.setScore28(i4 - 1);
        careerTestResult.setScore29(i5 - 1);
        careerTestResult.setScore30(i6 - 1);
        careerTestResult.setScore31(i7 - 1);
        careerTestResult.setScore32(i8 - 1);
    }

    @Transactional
    public void updateScore5(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.setScore33(i1 - 1);
        careerTestResult.setScore34(i2 - 1);
        careerTestResult.setScore35(i3 - 1);
        careerTestResult.setScore36(i4 - 1);
        careerTestResult.setScore37(i5 - 1);
        careerTestResult.setScore38(i6 - 1);
        careerTestResult.setScore39(i7 - 1);
        careerTestResult.setScore40(i8 - 1);
    }

    @Transactional
    public void updateScore6(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.setScore41(i1 - 1);
        careerTestResult.setScore42(i2 - 1);
        careerTestResult.setScore43(i3 - 1);
        careerTestResult.setScore44(i4 - 1);
        careerTestResult.setScore45(i5 - 1);
        careerTestResult.setScore46(i6 - 1);
        careerTestResult.setScore47(i7 - 1);
        careerTestResult.setScore48(i8 - 1);
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
        return andersonQuestionsRepository.findAll()
                .stream()
                .map(AndersonQuestion::getQuestions_description)
                .toList();
    }

    @Transactional
    public List<String> getMyBlackBox(MrAndersonTestResult mrAndersonTestResult) {
        List<String> list = new ArrayList<>();
        int levelA = fieldLevel(mrAndersonTestResult.getScoreAs());
        int levelB = fieldLevel(mrAndersonTestResult.getScoreBs());
        int levelC = fieldLevel(mrAndersonTestResult.getScoreCs());
        int levelD = fieldLevel(mrAndersonTestResult.getScoreDs());
        int levelE = fieldLevel(mrAndersonTestResult.getScoreEs());
        int levelF = fieldLevel(mrAndersonTestResult.getScoreFs());

        AndersonBlackbox blackboxA = andersonBlackboxRepository.findById(levelA).get();
        AndersonBlackbox blackboxB = andersonBlackboxRepository.findById(levelB).get();
        AndersonBlackbox blackboxC = andersonBlackboxRepository.findById(levelC).get();
        AndersonBlackbox blackboxD = andersonBlackboxRepository.findById(levelD).get();
        AndersonBlackbox blackboxE = andersonBlackboxRepository.findById(levelE).get();
        AndersonBlackbox blackboxF = andersonBlackboxRepository.findById(levelF).get();

        mrAndersonTestResult.setBlackBoxA_letters(blackboxA.getType());
        mrAndersonTestResult.setBlackboxA_comment(blackboxA.getFieldA());

        mrAndersonTestResult.setBlackBoxB_letters(blackboxB.getType());
        mrAndersonTestResult.setBlackboxB_comment(blackboxB.getFieldB());

        mrAndersonTestResult.setBlackBoxC_letters(blackboxC.getType());
        mrAndersonTestResult.setBlackboxC_comment(blackboxC.getFieldC());

        mrAndersonTestResult.setBlackBoxD_letters(blackboxD.getType());
        mrAndersonTestResult.setBlackboxD_comment(blackboxD.getFieldD());

        mrAndersonTestResult.setBlackBoxE_letters(blackboxE.getType());
        mrAndersonTestResult.setBlackboxE_comment(blackboxE.getFieldE());

        mrAndersonTestResult.setBlackBoxF_letters(blackboxF.getType());
        mrAndersonTestResult.setBlackboxF_comment(blackboxF.getFieldF());

        if (levelA <= 3) {
            list.add(blackboxA.getFieldA());
            list.add("");
            list.add("");
        } else {
            list.add("");
            list.add(blackboxA.getFieldA());
            list.add("");
        }
        if (levelB <= 3) {
            list.add(blackboxB.getFieldB());
            list.add("");
            list.add("");
        } else {
            list.add("");
            list.add(blackboxB.getFieldB());
            list.add("");
        }
        if (levelC <= 2) {
            list.add(blackboxC.getFieldC());
            list.add("");
            list.add("");
        } else if (levelC <= 4) {
            list.add("");
            list.add(blackboxC.getFieldC());
            list.add("");
        } else {
            list.add("");
            list.add("");
            list.add(blackboxC.getFieldC());

        }
        if (levelD <= 2) {
            list.add(blackboxD.getFieldD());
            list.add("");
            list.add("");
        } else if (levelD <= 4) {
            list.add("");
            list.add(blackboxD.getFieldD());
            list.add("");
        } else {
            list.add("");
            list.add("");
            list.add(blackboxD.getFieldD());
        }

        if (levelE <= 2) {
            list.add(blackboxE.getFieldE());
            list.add("");
            list.add("");
        } else if (levelE <= 4) {
            list.add("");
            list.add(blackboxE.getFieldE());
            list.add("");
        } else {
            list.add("");
            list.add("");
            list.add(blackboxE.getFieldE());
        }

        if (levelF <= 2) {
            list.add(blackboxF.getFieldF());
            list.add("");
            list.add("");
        } else if (levelD <= 4) {
            list.add("");
            list.add(blackboxF.getFieldF());
            list.add("");
        } else {
            list.add("");
            list.add("");
            list.add(blackboxF.getFieldF());
        }

        return list;
    }

    private int fieldLevel(int score) {
        if (score < 11) {
            return 1;
        } else if (score < 18) {
            return 2;
        } else if (score < 22) {
            return 3;
        } else if (score < 27) {
            return 4;
        } else if (score < 33) {
            return 5;
        } else {
            return 0;
        }
    }
}