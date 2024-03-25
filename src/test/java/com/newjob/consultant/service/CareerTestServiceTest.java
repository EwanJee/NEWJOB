package com.newjob.consultant.service;

import com.newjob.consultant.entity.CareerQuestion;
import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.repository.CareerQuestionRepository;
import com.newjob.consultant.repository.CareerTestResultRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CareerTestServiceTest {

    private final CareerTestResultRepository careerTestResultRepository = mock(CareerTestResultRepository.class);
    private final CareerQuestionRepository careerQuestionRepository = mock(CareerQuestionRepository.class);
    private final CareerTestService careerTestService = new CareerTestService(careerTestResultRepository,careerQuestionRepository);
    private static CareerTestResult result;

    @BeforeAll
    public static void init(){
        result = new CareerTestResult();
    }

    @Test
    @DisplayName("careerTestResultRepository save가 잘 동작하는지 확인")
    void join() {
        // given
        // when
        careerTestService.join(result);
        // then
        verify(careerTestResultRepository,times(1)).save(result);
    }

    @Test
    @DisplayName("careerTestResultRepository의 findByID가 적당히 호출 되어 location을 잘 반영했는지 확인 ")
    void updateLocation() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateLocation(1L,"location");
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
        Assertions.assertThat(result.getCareerLocation()).isEqualTo("location");
    }

    @Test
    @DisplayName("updateScore1이 잘 반영되어있느지 확인, score가 잘 반영됐는지 확인")
    void updateScore1() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore1(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
        Assertions.assertThat(result.getScore1()).isEqualTo(4);
    }

    @Test
    void updateScore2() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore2(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore3() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore3(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore4() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore4(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore5() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore5(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore6() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore6(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore7() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore7(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore8() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore8(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore9() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore9(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    void updateScore10() {
        //given
        careerTestService.join(result);
        when(careerTestResultRepository.findById(1L))
                .thenReturn(Optional.of(result));
        //when
        careerTestService.updateScore10(1L,4,4,4,4,4,4,4,4);
        //then
        verify(careerTestResultRepository,times(1)).findById(1L);
    }

    @Test
    @DisplayName("getCareerQuestions 예외를 구분할 수 있다")
    void getCareerQuestions() {
        //given
        when(careerQuestionRepository.findAll())
                .thenReturn(new ArrayList<>());
        //when
        List<String> careerQuestions = careerTestService.getCareerQuestions();
        //then
        Assertions.assertThat(careerQuestions.size()).isEqualTo(0);
    verify(careerQuestionRepository,times(1)).findAll();
    }

    @Test
    void findLowest2() {
        //given
        //when
        //then
    }
}