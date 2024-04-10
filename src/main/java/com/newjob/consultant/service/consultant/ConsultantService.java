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
        Consultant consultant = Consultant.builder()
                .email(consultantForm.getEmail())
                .name(consultantForm.getName())
                .phoneNumber(consultantForm.getPhoneNumber())
                .password(consultantForm.getPassword())
                .company(consultantForm.getCompany())
                .build();
        if (!isValidated(consultant)) {
            throw new IllegalStateException("이미 가입된 이메일 주소입니다");
        }
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
        mrAndersonTestResult.setConsultant(consultant);
        consultantRepository.save(consultant);
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
    }

    private boolean isValidated(Consultant consultant) {
        Optional<Consultant> consultant2 = consultantRepository.findByEmail(consultant.getEmail());
        return consultant2.isEmpty();
    }

    public ConsultantForm findByEmailAndPassword(String email, String password) {
        Optional<Consultant> consultant = consultantRepository.findByEmailAndPassword(email, password);
        if (consultant.isEmpty()) {
            throw new IllegalStateException("이메일 주소나 비밀번호가 잘못 되었습니다");
        }
        return ConsultantForm.builder()
                .email(consultant.get().getEmail())
                .name(consultant.get().getName())
                .phoneNumber(consultant.get().getPhoneNumber())
                .company(consultant.get().getCompany())
                .numberOfUsedCareerTests(consultant.get().getNumberOfUsedCarerTests())
                .numberOfAvailableCareerTests(consultant.get().getNumberOfAvailableCareerTests())
                .numberOfUsedMrAndersonTests(consultant.get().getNumberOfUsedMrAndersonTests())
                .numberOfAvailableMrAndersonTests(consultant.get().getNumberOfAvailableMrAndersonTests())
                .isApproved(consultant.get().getIsApproved())
                .build();
    }

    public ConsultantForm findById(Long id) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow();
        return ConsultantForm.builder()
                .email(consultant.getEmail())
                .name(consultant.getName())
                .phoneNumber(consultant.getPhoneNumber())
                .company(consultant.getCompany())
                .numberOfUsedCareerTests(consultant.getNumberOfUsedCarerTests())
                .numberOfAvailableCareerTests(consultant.getNumberOfAvailableCareerTests())
                .numberOfUsedMrAndersonTests(consultant.getNumberOfUsedMrAndersonTests())
                .numberOfAvailableMrAndersonTests(consultant.getNumberOfAvailableMrAndersonTests())
                .isApproved(consultant.getIsApproved())
                .build();
    }

    public List<Consultant> findAll() {
        return consultantRepository.findAll();
    }

    public boolean isValid4Test(ConsultantForm consultantForm) {
        int isApproved = consultantForm.getIsApproved();
        return isApproved != 0;
    }

    @Transactional
    public void updateNumberOfUsedCareerTests(Long id) {
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        int used = consultant.getNumberOfUsedCarerTests();
        consultant.setNumberOfUsedCarerTests(used + 1);
        int available = consultant.getNumberOfAvailableCareerTests();
        consultant.setNumberOfAvailableCareerTests(available - 1);
    }

    @Transactional
    public void updateNumberOfUsedMrAndersonTests(Long id) {
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        int used = consultant.getNumberOfUsedMrAndersonTests();
        consultant.setNumberOfUsedMrAndersonTests(used + 1);
        int available = consultant.getNumberOfAvailableMrAndersonTests();
        consultant.setNumberOfAvailableMrAndersonTests(available - 1);
    }
}
