package com.newjob.consultant.service;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.entity.MrAndersonTestResult;
import com.newjob.consultant.repository.CareerTestResultRepository;
import com.newjob.consultant.repository.ConsultantRepository;
import com.newjob.consultant.repository.MrAndersonTestResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ConsultantService {
    private final ConsultantRepository consultantRepository;
    private final CareerTestResultRepository careerTestResultRepository;
    private final MrAndersonTestResultRepository mrAndersonTestResultRepository;

    public List<CareerTestResult> getCList(long id) {
        Consultant c = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        return c.getCareerTestResultList();
    }

    public List<MrAndersonTestResult> getMList(long id) {
        Consultant c = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        return c.getMrAndersonTestResultList();
    }

    @Transactional
    public Long join(Consultant consultant) {
        consultantRepository.save(consultant);
        return consultant.getId();
    }

    @Transactional
    public void addCareerTest(Long consultantId, Long testId) {
        Consultant consultant = consultantRepository.findById(consultantId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        CareerTestResult careerTestResult = careerTestResultRepository.findById(testId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));
        consultant.putCareerTestResult(careerTestResult);
        careerTestResult.setConsultant(consultant);
        consultantRepository.save(consultant);
        careerTestResultRepository.save(careerTestResult);
    }

    @Transactional
    public void addMrAndersonTest(Long id, Long testId) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(testId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));
        consultant.putMrAndersonTestResult(mrAndersonTestResult);
        mrAndersonTestResult.setConsultant(consultant);
        consultantRepository.save(consultant);
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
    }

    public Consultant findByEmailAndPassword(String email, String password) {
        return consultantRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new NotFoundException(ErrorCode.LOGIN_FAILED));
    }

    public Consultant findById(Long id) {
        return consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
    }

    public List<Consultant> findAll() {
        return consultantRepository.findAll();
    }

    public boolean isValid4Test(Consultant consultant) {
        int isApproved = consultant.getIsApproved();
        return isApproved == 0;
    }

    @Transactional
    public void updateNumberOfUsedCareerTests(Long id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        int used = consultant.getNumberOfUsedCarerTests();
        consultant.setNumberOfUsedCarerTests(used + 1);
        int available = consultant.getNumberOfAvailableCareerTests();
        consultant.setNumberOfAvailableCareerTests(available - 1);
    }

    @Transactional
    public void updateNumberOfUsedMrAndersonTests(Long id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        int used = consultant.getNumberOfUsedMrAndersonTests();
        consultant.setNumberOfUsedMrAndersonTests(used + 1);
        int available = consultant.getNumberOfAvailableMrAndersonTests();
        consultant.setNumberOfAvailableMrAndersonTests(available - 1);
    }
}