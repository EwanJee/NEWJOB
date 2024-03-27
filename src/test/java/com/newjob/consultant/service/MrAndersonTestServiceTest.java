package com.newjob.consultant.service;

import com.newjob.consultant.entity.MrAndersonTestResult;
import com.newjob.consultant.repository.AndersonBlackboxRepository;
import com.newjob.consultant.repository.AndersonQuestionsRepository;
import com.newjob.consultant.repository.MrAndersonTestResultRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MrAndersonTestServiceTest {

    private final MrAndersonTestResultRepository mrAndersonTestResultRepository = mock(MrAndersonTestResultRepository.class);
    private final AndersonBlackboxRepository andersonBlackboxRepository = mock(AndersonBlackboxRepository.class);
    private final AndersonQuestionsRepository andersonQuestionsRepository = mock(AndersonQuestionsRepository.class);
    private final MrAndersonTestService mrAndersonTestService = new MrAndersonTestService(mrAndersonTestResultRepository,andersonBlackboxRepository,andersonQuestionsRepository);
    private final MrAndersonTestResult result = mock(MrAndersonTestResult.class);

//    @BeforeAll
//    public static void init(){
//        //given
//        result = new MrAndersonTestResult();
//    }


    @Test
    void join() {
        //given
        //when
        //then
        mrAndersonTestService.join(result);
        verify(mrAndersonTestResultRepository,times(1)).save(result);
//        Assertions.assertThat(mrAndersonTestResultRepository.findById(1L).get()).isEqualTo(result);
    }

    @Test
    void updateInfo() {
        //given
        Long id = 1L;
        String job = "job";
        String organization = "organization";
        String profession = "profession";
        String industry = "industry";
        when(mrAndersonTestResultRepository.findById(id))
                .thenReturn(Optional.of(result));
        //when
        mrAndersonTestService.updateInfo(id,job,organization,profession,industry);
        //then
        verify(mrAndersonTestResultRepository,times(1)).findById(id);
        verify(result,times(1)).setJob(job);
//        Assertions.assertThat(job).isEqualTo(result.getJob());
    }

    @Test
    void updateScore1() {
        //given
        when(mrAndersonTestResultRepository.findById(any()))
                .thenReturn(Optional.of(result));
        int point = 3;
        //when
        mrAndersonTestService.updateScore1(null,point,point,point,point,point,point,point,point);
        //then
        verify(mrAndersonTestResultRepository,times(1)).findById(any());
//        Assertions.assertThat(mrAndersonTestResultRepository.findById(1L).get()).isEqualTo(result);
    }

    /**
     * 밑의 두 메서드들은
     * DB에만 적재되어 있는 정보들을 가져와서 처리를 하는 메서드.
     */
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