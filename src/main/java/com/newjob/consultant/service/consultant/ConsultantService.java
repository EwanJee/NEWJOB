package com.newjob.consultant.service.consultant;

import com.newjob.consultant.entity.career.CareerTestResult;
import com.newjob.consultant.entity.consultant.Consultant;
import com.newjob.consultant.entity.consultant.dto.ConsultantForm;
import com.newjob.consultant.entity.mranderson.MrAndersonTestResult;
import com.newjob.consultant.repository.career.CareerTestResultRepository;
import com.newjob.consultant.repository.consultant.ConsultantRepository;
import com.newjob.consultant.repository.mranderson.MrAndersonTestResultRepository;
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
        Consultant c = consultantRepository.findById(id).orElse(null);
        return c.getCareerTestResultList();
    }

    public List<MrAndersonTestResult> getMList(long id) {
        Consultant c = consultantRepository.findById(id).orElse(null);
        return c.getMrAndersonTestResultList();
    }

    @Transactional
    public Long join(ConsultantForm consultantForm) {
        if(consultantRepository.existsByEmail(consultantForm.getEmail())){
            throw new IllegalStateException("이미 가입된 이메일 주소 입니다");
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
        Consultant consultant = consultantRepository.findById(consultantId).orElse(null);
        CareerTestResult careerTestResult = careerTestResultRepository.findById(testId).orElse(null);
        consultant.putCareerTestResult(careerTestResult);
        careerTestResult.updateConsultant(consultant);
        consultantRepository.save(consultant);
        careerTestResultRepository.save(careerTestResult);
    }

    @Transactional
    public void addMrAndersonTest(Long id, Long testId) {
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(testId).orElse(null);
        consultant.putMrAndersonTestResult(mrAndersonTestResult);
        mrAndersonTestResult.updateConsultant(consultant);
        consultantRepository.save(consultant);
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
    }

    public ConsultantForm findByEmailAndPassword(String email, String password) {
        Consultant consultant = consultantRepository.findByEmailAndPassword(email, password)
                .orElseThrow();
        return ConsultantForm.of(consultant);
    }

    public ConsultantForm findById(Long id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow();
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
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        consultant.updateUsedCareerTestsAndAvailableCareerTests();
    }

    @Transactional
    public void updateNumberOfUsedMrAndersonTests(Long id) {
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        consultant.updateUsedMrAndersonTestsAndAvailableMrAndersonTests();
    }
}
