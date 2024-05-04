package com.newjob.consultant.service.career;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
import com.newjob.consultant.entity.career.CareerQuestion;
import com.newjob.consultant.entity.career.CareerTestResult;
import com.newjob.consultant.controller.career.dto.CareerTestFinishedResultForm;
import com.newjob.consultant.controller.career.dto.CareerTestResultForm;
import com.newjob.consultant.repository.career.CareerQuestionRepository;
import com.newjob.consultant.repository.career.CareerTestResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CareerTestService {
    private final CareerTestResultRepository careerTestResultRepository;
    private final CareerQuestionRepository careerQuestionRepository;

    @Transactional
    public Long join(CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult =
                CareerTestResult.builder()
                        .memberName(careerTestResultForm.getMemberName())
                        .consultantName(careerTestResultForm.getConsultantName())
                        .organization(careerTestResultForm.getOrganization())
                        .consultantCompany(careerTestResultForm.getConsultantCompany())
                        .build();
        careerTestResultRepository.save(careerTestResult);
        return careerTestResult.getId();
    }

    @Transactional
    public void updateLocation(Long id, String location) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateCareerLocation(location);
    }

    @Transactional
    public void updateScore(Long id, int score1, int score2, int score3, int score4, int score5, int score6, int score7, int score8) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.getQuestionScores().add(score1);
        careerTestResult.getQuestionScores().add(score2);
        careerTestResult.getQuestionScores().add(score3);
        careerTestResult.getQuestionScores().add(score4);
        careerTestResult.getQuestionScores().add(score5);
        careerTestResult.getQuestionScores().add(score6);
        careerTestResult.getQuestionScores().add(score7);
        careerTestResult.getQuestionScores().add(score8);

        if (careerTestResult.getQuestionScores().size() == 80) {
            careerTestResult.matchingScore();
        }
    }

    public CareerTestFinishedResultForm findFinishedResult(Long id) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() ->new NotFoundException(ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        return CareerTestFinishedResultForm.builder()
                .memberName(careerTestResult.getMemberName())
                .consultantName(careerTestResult.getConsultantName())
                .scoreA(careerTestResult.getScoreA())
                .scoreB(careerTestResult.getScoreB())
                .scoreC(careerTestResult.getScoreC())
                .scoreD(careerTestResult.getScoreD())
                .scoreE(careerTestResult.getScoreE())
                .scoreF(careerTestResult.getScoreF())
                .scoreG(careerTestResult.getScoreG())
                .scoreH(careerTestResult.getScoreH())
                .scoreI(careerTestResult.getScoreI())
                .scoreJ(careerTestResult.getScoreJ())
                .scoreK(careerTestResult.getScoreK())
                .scoreL(careerTestResult.getScoreL())
                .scoreM(careerTestResult.getScoreM())
                .scoreN(careerTestResult.getScoreN())
                .scoreO(careerTestResult.getScoreO())
                .scoreW(careerTestResult.getScoreW())
                .scoreCharacter(careerTestResult.getScoreCharacter())
                .scoreConnection(careerTestResult.getScoreConnection())
                .scoreChallenge(careerTestResult.getScoreChallenge())
                .scoreControl(careerTestResult.getScoreControl())
                .scoreAbility(careerTestResult.getScoreAbility())
                .scoreNetworkPower(careerTestResult.getScoreNetworkPower())
                .scoreMoveOn(careerTestResult.getScoreMoveOn())
                .build();
    }

    public List<String> getCareerQuestions() {
        return careerQuestionRepository.findAll()
                .stream()
                .map(CareerQuestion::getCareerQuestionsDescription)
                .toList();
    }

    public List<String> findLowest2(Long id) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        Map<String, Integer> map = new HashMap<>();
        map.put("What", careerTestResult.getScoreO());
        map.put("Why", careerTestResult.getScoreI());
        map.put("성과/평가", careerTestResult.getScoreE());
        map.put("네트워크", careerTestResult.getScoreL());
        map.put("팀웍/동료", careerTestResult.getScoreN());
        map.put("조직", careerTestResult.getScoreF());
        map.put("업계", careerTestResult.getScoreA());
        map.put("전문분야", careerTestResult.getScoreJ());
        map.put("영역확장", careerTestResult.getScoreB());
        map.put("영역개발", careerTestResult.getScoreM());
        map.put("업무재조성", careerTestResult.getScoreG());
        map.put("지원개발", careerTestResult.getScoreH());
        map.put("학습계획", careerTestResult.getScoreC());
        map.put("실천", careerTestResult.getScoreK());
        map.put("월드지수", careerTestResult.getScoreW());

        List<String> lowestTwo =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .limit(2)
                        .map(Map.Entry::getKey)
                        .toList();

        String firstLowest = lowestTwo.get(0);
        String secondLowest = lowestTwo.get(1);

        List<CareerQuestion> questionList = careerQuestionRepository.findAll();
        List<String> questionsForLowest2 = new ArrayList<>();

        for (CareerQuestion careerQuestion : questionList) {
            if (careerQuestion.getCareerQuestionsType().equals(firstLowest))
                questionsForLowest2.add(careerQuestion.getCareerQuestionsDescription());
        }
        for (CareerQuestion careerQuestion : questionList) {
            if (careerQuestion.getCareerQuestionsType().equals(secondLowest))
                questionsForLowest2.add(careerQuestion.getCareerQuestionsDescription());
        }
        return questionsForLowest2;
    }
}
