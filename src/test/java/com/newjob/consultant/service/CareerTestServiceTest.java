package com.newjob.consultant.service;

import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.repository.CareerQuestionRepository;
import com.newjob.consultant.repository.CareerTestResultRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CareerTestServiceTest {

    private final CareerTestResultRepository careerTestResultRepository = mock(CareerTestResultRepository.class);
    private final CareerQuestionRepository careerQuestionRepository = mock(CareerQuestionRepository.class);
    private final CareerTestService careerTestService = new CareerTestService(careerTestResultRepository,careerQuestionRepository);

    @Test
    void join() {
        // given
        CareerTestResult result = new CareerTestResult();
        // when
        careerTestService.join(result);
        // then
        verify(careerTestResultRepository,times(1)).save(result);
    }

    @Test
    void updateLocation() {
        //given
        //when
        //then
    }

    @Test
    void updateScore1() {
        //given
        //when
        //then
    }

    @Test
    void updateScore2() {
        //given
        //when
        //then
    }

    @Test
    void updateScore3() {
        //given
        //when
        //then
    }

    @Test
    void updateScore4() {
        //given
        //when
        //then
    }

    @Test
    void updateScore5() {
        //given
        //when
        //then
    }

    @Test
    void updateScore6() {
        //given
        //when
        //then
    }

    @Test
    void updateScore7() {
        //given
        //when
        //then
    }

    @Test
    void updateScore8() {
        //given
        //when
        //then
    }

    @Test
    void updateScore9() {
        //given
        //when
        //then
    }

    @Test
    void updateScore10() {
        //given
        //when
        //then
    }

    @Test
    void findById() {
        //given
        //when
        //then
    }

    @Test
    void getCareerQuestions() {
        //given
        //when
        //then
    }

    @Test
    void findLowest2() {
        //given
        //when
        //then
    }
}