package com.newjob.consultant.service.mranderson;

import com.newjob.consultant.entity.mranderson.AndersonBlackbox;
import com.newjob.consultant.entity.mranderson.MrAndersonTestResult;
import com.newjob.consultant.entity.mranderson.dto.MrAndersonTestResultForm;
import com.newjob.consultant.repository.mranderson.AndersonBlackboxRepository;
import com.newjob.consultant.entity.mranderson.AndersonQuestion;
import com.newjob.consultant.repository.mranderson.AndersonQuestionsRepository;
import com.newjob.consultant.repository.mranderson.MrAndersonTestResultRepository;
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
    public Long join(MrAndersonTestResultForm mrAndersonTestResultForm) {
        MrAndersonTestResult mrAndersonTestResult = MrAndersonTestResult.builder()
                .memberName(mrAndersonTestResultForm.getMemberName())
                .consultantName(mrAndersonTestResultForm.getConsultantName())
                .organization(mrAndersonTestResultForm.getOrganization())
                .consultantCompany(mrAndersonTestResultForm.getConsultantCompany())
                .build();
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
        return mrAndersonTestResult.getId();
    }

    public Optional<MrAndersonTestResult> findById(Long id) {
        return mrAndersonTestResultRepository.findById(id);
    }

    @Transactional
    public void updateInfo(Long id, String job, String organization, String profession, String industry) {
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        mrAndersonTestResult.updateInfo(job, organization, profession, industry);
    }

    @Transactional
    public void updateScore(Long id, int score1, int score2, int score3, int score4, int score5, int score6, int score7, int score8) {
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(id).orElse(null);
        mrAndersonTestResult.getQuestionScores().add(score1 - 1);
        mrAndersonTestResult.getQuestionScores().add(score2 - 1);
        mrAndersonTestResult.getQuestionScores().add(score3 - 1);
        mrAndersonTestResult.getQuestionScores().add(score4 - 1);
        mrAndersonTestResult.getQuestionScores().add(score5 - 1);
        mrAndersonTestResult.getQuestionScores().add(score6 - 1);
        mrAndersonTestResult.getQuestionScores().add(score7 - 1);
        mrAndersonTestResult.getQuestionScores().add(score8 - 1);
        if (mrAndersonTestResult.getQuestionScores().size() == 48) {
            mrAndersonTestResult.matchScoreGroup();
            mrAndersonTestResult.matchColorA();
            mrAndersonTestResult.matchColorB();
            mrAndersonTestResult.matchColorC();
            mrAndersonTestResult.matchColorD();
            mrAndersonTestResult.matchColorE();
            mrAndersonTestResult.matchColorF();
            getMyBlackBox(mrAndersonTestResult);
        }
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
