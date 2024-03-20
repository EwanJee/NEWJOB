package com.newjob.consultant.service;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
import com.newjob.consultant.controller.CareerTestResultForm;
import com.newjob.consultant.entity.CareerQuestion;
import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.repository.CareerQuestionRepository;
import com.newjob.consultant.repository.CareerTestResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CareerTestService {
    private final CareerTestResultRepository careerTestResultRepository;
    private final CareerQuestionRepository careerQuestionRepository;

    @Transactional
    public void join(CareerTestResult careerTestResult) {
        careerTestResultRepository.save(careerTestResult);
    }

    @Transactional
    public void updateLocation(Long id, String location) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateCareerLocation(location);
    }

    @Transactional
    public void updateScore1(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage1(careerTestResult.getScore1(),
                careerTestResultForm.getScore2(),
                careerTestResultForm.getScore3(),
                careerTestResultForm.getScore4(),
                careerTestResultForm.getScore5(),
                careerTestResultForm.getScore6(),
                careerTestResultForm.getScore7(),
                careerTestResultForm.getScore8());
    }

    @Transactional
    public void updateScore2(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage2(careerTestResult.getScore9(),
                careerTestResultForm.getScore10(),
                careerTestResultForm.getScore11(),
                careerTestResultForm.getScore12(),
                careerTestResultForm.getScore13(),
                careerTestResultForm.getScore14(),
                careerTestResultForm.getScore15(),
                careerTestResultForm.getScore16());
    }

    @Transactional
    public void updateScore3(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage3(careerTestResult.getScore17(),
                careerTestResultForm.getScore18(),
                careerTestResultForm.getScore19(),
                careerTestResultForm.getScore20(),
                careerTestResultForm.getScore21(),
                careerTestResultForm.getScore22(),
                careerTestResultForm.getScore23(),
                careerTestResultForm.getScore24());
    }

    @Transactional
    public void updateScore4(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage4(careerTestResult.getScore25(),
                careerTestResultForm.getScore26(),
                careerTestResultForm.getScore27(),
                careerTestResultForm.getScore28(),
                careerTestResultForm.getScore29(),
                careerTestResultForm.getScore30(),
                careerTestResultForm.getScore31(),
                careerTestResultForm.getScore32());
    }

    @Transactional
    public void updateScore5(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage5(careerTestResult.getScore33(),
                careerTestResultForm.getScore34(),
                careerTestResultForm.getScore35(),
                careerTestResultForm.getScore36(),
                careerTestResultForm.getScore37(),
                careerTestResultForm.getScore38(),
                careerTestResultForm.getScore39(),
                careerTestResultForm.getScore40());
    }

    @Transactional
    public void updateScore6(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage6(careerTestResult.getScore41(),
                careerTestResultForm.getScore42(),
                careerTestResultForm.getScore43(),
                careerTestResultForm.getScore44(),
                careerTestResultForm.getScore45(),
                careerTestResultForm.getScore46(),
                careerTestResultForm.getScore47(),
                careerTestResultForm.getScore48());
    }

    @Transactional
    public void updateScore7(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage7(careerTestResult.getScore49(),
                careerTestResultForm.getScore50(),
                careerTestResultForm.getScore51(),
                careerTestResultForm.getScore52(),
                careerTestResultForm.getScore53(),
                careerTestResultForm.getScore54(),
                careerTestResultForm.getScore55(),
                careerTestResultForm.getScore56());
    }

    @Transactional
    public void updateScore8(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage8(careerTestResult.getScore57(),
                careerTestResultForm.getScore58(),
                careerTestResultForm.getScore59(),
                careerTestResultForm.getScore60(),
                careerTestResultForm.getScore61(),
                careerTestResultForm.getScore62(),
                careerTestResultForm.getScore63(),
                careerTestResultForm.getScore64());
    }

    @Transactional
    public void updateScore9(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage9(careerTestResult.getScore65(),
                careerTestResultForm.getScore66(),
                careerTestResultForm.getScore67(),
                careerTestResultForm.getScore68(),
                careerTestResultForm.getScore69(),
                careerTestResultForm.getScore70(),
                careerTestResultForm.getScore71(),
                careerTestResultForm.getScore72());
    }

    @Transactional
    public void updateScore10(Long id, CareerTestResultForm careerTestResultForm) {
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        careerTestResult.updateScoreForPage10(careerTestResult.getScore73(),
                careerTestResultForm.getScore74(),
                careerTestResultForm.getScore75(),
                careerTestResultForm.getScore76(),
                careerTestResultForm.getScore77(),
                careerTestResultForm.getScore78(),
                careerTestResultForm.getScore79(),
                careerTestResultForm.getScore80());

        careerTestResult.matchingScore();
    }

    public CareerTestResult findById(Long id) {
        return careerTestResultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CareerTest Not Found", ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
    }

    public List<String> getCareerQuestions() {
        return careerQuestionRepository.findAll()
                .stream()
                .map(CareerQuestion::getCareerQuestionsDescription)
                .toList();
    }

    public List<String> findLowest2(CareerTestResult careerTestResult) {
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
