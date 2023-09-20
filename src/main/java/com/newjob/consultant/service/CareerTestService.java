package com.newjob.consultant.service;

import com.newjob.consultant.controller.CareerTestResultForm;
import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.repository.CareerTestResultRepository;
import com.newjob.consultant.repository.JdbcCareerTestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CareerTestService {
    private final JdbcCareerTestRepository jdbcCareerTestRepository;
    private final CareerTestResultRepository careerTestResultRepository;
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
    public CareerTestResult mapQuestions(CareerTestResultForm form){
        CareerTestResult careerTestResult = new CareerTestResult(
                form.getScore1(),
                form.getScore2(),
                form.getScore3(),
                form.getScore4(),
                form.getScore5(),
                form.getScore6(),
                form.getScore7(),
                form.getScore8(),
                form.getScore9(),
                form.getScore10(),
                form.getScore11(),
                form.getScore12(),
                form.getScore13(),
                form.getScore14(),
                form.getScore15(),
                form.getScore16(),
                form.getScore17(),
                form.getScore18(),
                form.getScore19(),
                form.getScore20(),
                form.getScore21(),
                form.getScore22(),
                form.getScore23(),
                form.getScore24(),
                form.getScore25(),
                form.getScore26(),
                form.getScore27(),
                form.getScore28(),
                form.getScore29(),
                form.getScore30(),
                form.getScore31(),
                form.getScore32(),
                form.getScore33(),
                form.getScore34(),
                form.getScore35(),
                form.getScore36(),
                form.getScore37(),
                form.getScore38(),
                form.getScore39(),
                form.getScore40(),
                form.getScore41(),
                form.getScore42(),
                form.getScore43(),
                form.getScore44(),
                form.getScore45(),
                form.getScore46(),
                form.getScore47(),
                form.getScore48(),
                form.getScore49(),
                form.getScore50(),
                form.getScore51(),
                form.getScore52(),
                form.getScore53(),
                form.getScore54(),
                form.getScore55(),
                form.getScore56(),
                form.getScore57(),
                form.getScore58(),
                form.getScore59(),
                form.getScore60(),
                form.getScore61(),
                form.getScore62(),
                form.getScore63(),
                form.getScore64(),
                form.getScore65(),
                form.getScore66(),
                form.getScore67(),
                form.getScore68(),
                form.getScore69(),
                form.getScore70(),
                form.getScore71(),
                form.getScore72(),
                form.getScore73(),
                form.getScore74(),
                form.getScore75(),
                form.getScore76(),
                form.getScore77(),
                form.getScore78(),
                form.getScore79(),
                form.getScore80() );
        careerTestResult.matchingScore();
        return careerTestResult;
    }
    /*public Page<String> findCareerQuestionsByPage(Pageable pageable){
        return JdbcCareerTestRepository.findAll(pageable);
    }*/
    public List<String> getCareerQuestions(){
        return jdbcCareerTestRepository.getCareerQuestions();
    }
    public List<String> findLowest2(CareerTestResult careerTestResult){
        List<Integer> scores = new ArrayList<Integer>();
        scores.add(careerTestResult.getScoreA());
        scores.add(careerTestResult.getScoreB());
        scores.add(careerTestResult.getScoreC());
        scores.add(careerTestResult.getScoreD());
        scores.add(careerTestResult.getScoreE());
        scores.add(careerTestResult.getScoreF());
        scores.add(careerTestResult.getScoreG());
        scores.add(careerTestResult.getScoreH());
        scores.add(careerTestResult.getScoreI());
        scores.add(careerTestResult.getScoreJ());
        scores.add(careerTestResult.getScoreK());
        scores.add(careerTestResult.getScoreL());
        scores.add(careerTestResult.getScoreM());
        scores.add(careerTestResult.getScoreN());
        scores.add(careerTestResult.getScoreO());

        int smallest1 = Integer.MAX_VALUE;
        int smallest2 = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;

        for(int i=0; i<scores.size(); i++){
            if(scores.get(i) < smallest1){
                smallest2 = smallest1;
                smallest1 = scores.get(i);
                index1 = i+1;
            }
            else if(scores.get(i) < smallest2){
                smallest2 = scores.get(i);
                index2 = i+1;
            }
        }
        List<String> Lowest2 = new ArrayList<>();
        List<String> first = jdbcCareerTestRepository.getQuestionsMappedByType(index1);
        List<String> second = jdbcCareerTestRepository.getQuestionsMappedByType(index2);
        Lowest2.add(first.get(0));
        Lowest2.add(first.get(1));
        Lowest2.add(first.get(2));
        Lowest2.add(first.get(3));
        Lowest2.add(first.get(4));

        Lowest2.add(second.get(0));
        Lowest2.add(second.get(1));
        Lowest2.add(second.get(2));
        Lowest2.add(second.get(3));
        Lowest2.add(second.get(4));
        return Lowest2;
    }
}
