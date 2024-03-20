package com.newjob.consultant.service;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
import com.newjob.consultant.controller.MrAndersonTestResultForm;
import com.newjob.consultant.entity.AndersonBlackbox;
import com.newjob.consultant.entity.MrAndersonTestResult;
import com.newjob.consultant.repository.AndersonBlackboxRepository;
import com.newjob.consultant.entity.AndersonQuestion;
import com.newjob.consultant.repository.AndersonQuestionsRepository;
import com.newjob.consultant.repository.JdbcMrAndersonTestRepository;
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

    public MrAndersonTestResult findById(Long id) {
        return mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
    }

    @Transactional
    public void updateInfo(Long id, MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        mrAndersonTestResult.updateInfo(mrAndersonTestResultForm);
    }

    @Transactional
    public void updateScore1(Long id, MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForRound1(mrAndersonTestResultForm);
    }

    @Transactional
    public void updateScore2(Long id, MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForRound2(mrAndersonTestResultForm);
    }

    @Transactional
    public void updateScore3(Long id, MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForRound3(mrAndersonTestResultForm);
    }

    @Transactional
    public void updateScore4(Long id, MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForRound4(mrAndersonTestResultForm);
    }

    @Transactional
    public void updateScore5(Long id, MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForRound5(mrAndersonTestResultForm);
    }

    @Transactional
    public void updateScore6(Long id, MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult careerTestResult = mrAndersonTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Anderson Test Not Found", ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForRound6(mrAndersonTestResultForm);
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

        mrAndersonTestResult.updateBlackBox(blackboxA, blackboxB, blackboxC, blackboxD, blackboxE, blackboxF);

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
