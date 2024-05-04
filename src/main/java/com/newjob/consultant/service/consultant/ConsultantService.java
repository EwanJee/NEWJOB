package com.newjob.consultant.service.consultant;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
import com.newjob.consultant.entity.career.CareerTestResult;
import com.newjob.consultant.entity.consultant.Consultant;
import com.newjob.consultant.controller.consultant.dto.ConsultantForm;
import com.newjob.consultant.entity.mranderson.MrAndersonTestResult;
import com.newjob.consultant.repository.career.CareerTestResultRepository;
import com.newjob.consultant.repository.consultant.ConsultantRepository;
import com.newjob.consultant.repository.mranderson.MrAndersonTestResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));;
        return c.getMrAndersonTestResultList();
    }

    @Transactional
    public Long join(ConsultantForm consultantForm) {
        if(consultantRepository.existsByEmail(consultantForm.getEmail())){
            throw new NotFoundException(ErrorCode.MEMBER_ALREADY_EXISTS);
        }
        Consultant consultant = Consultant.builder()
                .email(consultantForm.getEmail())
                .name(consultantForm.getName())
                .phoneNumber(consultantForm.getPhoneNumber())
                .password(consultantForm.getPassword())
                .company(consultantForm.getCompany())
                .build();
        consultantRepository.save(consultant);
        return consultant.getId();
    }

    @Transactional
    public void addCareerTest(Long consultantId, Long testId) {
        Consultant consultant = consultantRepository.findById(consultantId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));;
        CareerTestResult careerTestResult = careerTestResultRepository.findById(testId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CAREER_TEST_RESULT_NOT_FOUND));;
        consultant.putCareerTestResult(careerTestResult);
        careerTestResult.updateConsultant(consultant);
        consultantRepository.save(consultant);
        careerTestResultRepository.save(careerTestResult);
    }

    @Transactional
    public void addMrAndersonTest(Long id, Long testId) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));;
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(testId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ANDERSON_TEST_RESULT_NOT_FOUND));;
        consultant.putMrAndersonTestResult(mrAndersonTestResult);
        mrAndersonTestResult.updateConsultant(consultant);
        consultantRepository.save(consultant);
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
    }

    public ConsultantForm findByEmailAndPassword(String email, String password) {
        Consultant consultant = consultantRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        return ConsultantForm.of(consultant);
    }

    public ConsultantForm findById(Long id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        return ConsultantForm.of(consultant);
    }

    public List<ConsultantForm> findAll() {
        List<Consultant> consultants = consultantRepository.findAll();
        return consultants.stream()
                .map(ConsultantForm::of)
                .toList();
    }

    @Transactional
    public void updateNumberOfUsedCareerTests(Long id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        consultant.updateUsedCareerTestsAndAvailableCareerTests();
    }

    @Transactional
    public void updateNumberOfUsedMrAndersonTests(Long id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        consultant.updateUsedMrAndersonTestsAndAvailableMrAndersonTests();
    }
}
