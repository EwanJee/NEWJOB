package com.newjob.consultant.service;

import com.newjob.consultant.entity.MrAndersonTestResult;
import com.newjob.consultant.repository.AndersonBlackboxRepository;
import com.newjob.consultant.repository.AndersonQuestionsRepository;
import com.newjob.consultant.repository.MrAndersonTestResultRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
class MrAndersonTestServiceTest {

    private final MrAndersonTestResultRepository mrAndersonTestResultRepository = mock(MrAndersonTestResultRepository.class);
    private final AndersonBlackboxRepository andersonBlackboxRepository = mock(AndersonBlackboxRepository.class);
    private final AndersonQuestionsRepository andersonQuestionsRepository = mock(AndersonQuestionsRepository.class);
    private final MrAndersonTestService mrAndersonTestService = new MrAndersonTestService(mrAndersonTestResultRepository,andersonBlackboxRepository,andersonQuestionsRepository);
    private static MrAndersonTestResult result;

    @BeforeAll
    public static void init(){
        result = new MrAndersonTestResult();
    }


    @Test
    void join() {
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
    void updateInfo() {
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
    void getMrAndersonQuestions() {
        //given
        //when
        //then
    }

    @Test
    void getMyBlackBox() {
        //given
        //when
        //then
    }
}