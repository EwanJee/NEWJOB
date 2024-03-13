package com.newjob.consultant.service;

import com.newjob.consultant.entity.CareerQuestion;
import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.repository.CareerQuestionRepository;
import com.newjob.consultant.repository.CareerTestResultRepository;
import com.newjob.consultant.repository.JdbcCareerTestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CareerTestService {
    private final JdbcCareerTestRepository jdbcCareerTestRepository;
    private final CareerTestResultRepository careerTestResultRepository;
    private final CareerQuestionRepository careerQuestionRepository;
    @Transactional
    public void join(CareerTestResult careerTestResult){
        careerTestResultRepository.save(careerTestResult);
    }

    @Transactional
    public void updateLocation(Long id, String location){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setCareerLocation(location);
    }
    @Transactional
    public void updateScore1(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore1(i1);
        careerTestResult.setScore2(i2);
        careerTestResult.setScore3(i3);
        careerTestResult.setScore4(i4);
        careerTestResult.setScore5(i5);
        careerTestResult.setScore6(i6);
        careerTestResult.setScore7(i7);
        careerTestResult.setScore8(i8);
    }
    @Transactional
    public void updateScore2(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore9(i1);
        careerTestResult.setScore10(i2);
        careerTestResult.setScore11(i3);
        careerTestResult.setScore12(i4);
        careerTestResult.setScore13(i5);
        careerTestResult.setScore14(i6);
        careerTestResult.setScore15(i7);
        careerTestResult.setScore16(i8);
    }
    @Transactional
    public void updateScore3(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore17(i1);
        careerTestResult.setScore18(i2);
        careerTestResult.setScore19(i3);
        careerTestResult.setScore20(i4);
        careerTestResult.setScore21(i5);
        careerTestResult.setScore22(i6);
        careerTestResult.setScore23(i7);
        careerTestResult.setScore24(i8);
    }
    @Transactional
    public void updateScore4(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore25(i1);
        careerTestResult.setScore26(i2);
        careerTestResult.setScore27(i3);
        careerTestResult.setScore28(i4);
        careerTestResult.setScore29(i5);
        careerTestResult.setScore30(i6);
        careerTestResult.setScore31(i7);
        careerTestResult.setScore32(i8);
    }
    @Transactional
    public void updateScore5(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore33(i1);
        careerTestResult.setScore34(i2);
        careerTestResult.setScore35(i3);
        careerTestResult.setScore36(i4);
        careerTestResult.setScore37(i5);
        careerTestResult.setScore38(i6);
        careerTestResult.setScore39(i7);
        careerTestResult.setScore40(i8);
    }
    @Transactional
    public void updateScore6(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore41(i1);
        careerTestResult.setScore42(i2);
        careerTestResult.setScore43(i3);
        careerTestResult.setScore44(i4);
        careerTestResult.setScore45(i5);
        careerTestResult.setScore46(i6);
        careerTestResult.setScore47(i7);
        careerTestResult.setScore48(i8);
    }
    @Transactional
    public void updateScore7(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore49(i1);
        careerTestResult.setScore50(i2);
        careerTestResult.setScore51(i3);
        careerTestResult.setScore52(i4);
        careerTestResult.setScore53(i5);
        careerTestResult.setScore54(i6);
        careerTestResult.setScore55(i7);
        careerTestResult.setScore56(i8);
    }
    @Transactional
    public void updateScore8(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore57(i1);
        careerTestResult.setScore58(i2);
        careerTestResult.setScore59(i3);
        careerTestResult.setScore60(i4);
        careerTestResult.setScore61(i5);
        careerTestResult.setScore62(i6);
        careerTestResult.setScore63(i7);
        careerTestResult.setScore64(i8);
    }
    @Transactional
    public void updateScore9(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore65(i1);
        careerTestResult.setScore66(i2);
        careerTestResult.setScore67(i3);
        careerTestResult.setScore68(i4);
        careerTestResult.setScore69(i5);
        careerTestResult.setScore70(i6);
        careerTestResult.setScore71(i7);
        careerTestResult.setScore72(i8);
    }
    @Transactional
    public void updateScore10(Long id, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8){
        CareerTestResult careerTestResult = careerTestResultRepository.findById(id).orElse(null);
        careerTestResult.setScore73(i1);
        careerTestResult.setScore74(i2);
        careerTestResult.setScore75(i3);
        careerTestResult.setScore76(i4);
        careerTestResult.setScore77(i5);
        careerTestResult.setScore78(i6);
        careerTestResult.setScore79(i7);
        careerTestResult.setScore80(i8);

        careerTestResult.matchingScore();
    }
    public Optional<CareerTestResult> findById(Long id){
        return careerTestResultRepository.findById(id);
    }
    public List<String> getCareerQuestions(){
        return careerQuestionRepository.findAll()
                .stream()
                .map(CareerQuestion::getCareerQuestionsDescription)
                .toList();
    }
    public List<String> findLowest2(CareerTestResult careerTestResult){
        Map<String,Integer> map = new HashMap<>();
        map.put("What",careerTestResult.getScoreO());
        map.put("Why",careerTestResult.getScoreI());
        map.put("성과/평가",careerTestResult.getScoreE());
        map.put("네트워크",careerTestResult.getScoreL());
        map.put("팀웍/동료",careerTestResult.getScoreN());
        map.put("조직",careerTestResult.getScoreF());
        map.put("업계",careerTestResult.getScoreA());
        map.put("전문분야",careerTestResult.getScoreJ());
        map.put("영역확장",careerTestResult.getScoreB());
        map.put("영역개발",careerTestResult.getScoreM());
        map.put("업무재조성",careerTestResult.getScoreG());
        map.put("지원개발",careerTestResult.getScoreH());
        map.put("학습계획",careerTestResult.getScoreC());
        map.put("실천",careerTestResult.getScoreK());
        map.put("월드지수",careerTestResult.getScoreW());

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

        for(CareerQuestion careerQuestion : questionList){
            if(careerQuestion.getCareerQuestionsType().equals(firstLowest))
                questionsForLowest2.add(careerQuestion.getCareerQuestionsDescription());
        }
        for(CareerQuestion careerQuestion : questionList){
            if(careerQuestion.getCareerQuestionsType().equals(secondLowest))
                questionsForLowest2.add(careerQuestion.getCareerQuestionsDescription());
        }
        return questionsForLowest2;
    }
}
