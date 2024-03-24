package com.newjob.consultant.service;

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
public class ConsultantService{
    private final ConsultantRepository consultantRepository;
    private final CareerTestResultRepository careerTestResultRepository;
    private final MrAndersonTestResultRepository mrAndersonTestResultRepository;
    public List<CareerTestResult> getCList(long id){
        Consultant c = consultantRepository.findById(id).orElse(null);
        List<CareerTestResult> list = c.getCareerTestResultList();
        return list;
    }
    public List<MrAndersonTestResult> getMList(long id){
        Consultant c = consultantRepository.findById(id).orElse(null);
        List<MrAndersonTestResult> list = c.getMrAndersonTestResultList();
        return list;
    }

    @Transactional
    public Long join(Consultant consultant){
        isValidated(consultant);
        consultantRepository.save(consultant);
        return consultant.getId();
    }
    @Transactional
    public void addCareerTest(Long consultantId, Long testId){
        Consultant consultant = consultantRepository.findById(consultantId).orElse(null);
        CareerTestResult careerTestResult = careerTestResultRepository.findById(testId).orElse(null);
        consultant.putCareerTestResult(careerTestResult);
        careerTestResult.setConsultant(consultant);
        consultantRepository.save(consultant);
        careerTestResultRepository.save(careerTestResult);
    }
    @Transactional
    public void addMrAndersonTest(Long id, Long testId){
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        MrAndersonTestResult mrAndersonTestResult = mrAndersonTestResultRepository.findById(testId).orElse(null);
        consultant.putMrAndersonTestResult(mrAndersonTestResult);
        mrAndersonTestResult.setConsultant(consultant);
        consultantRepository.save(consultant);
        mrAndersonTestResultRepository.save(mrAndersonTestResult);
    }

    private void isValidated(Consultant consultant){
        Optional<Consultant> consultant2 = consultantRepository.findByEmail(consultant.getEmail());
        if(consultant2.isPresent()){
            throw new IllegalStateException("이미 존재하는 이메일 주소 입니다");
        }
    }
    public Consultant findByEmailAndPassword(String email, String password){
        Optional<Consultant> consultant = consultantRepository.findByEmailAndPassword(email,password);
        if(consultant.isEmpty()){
            throw new IllegalStateException("이메일 주소나 비밀번호가 잘못 되었습니다");
        }
        else{
            return consultant.orElse(null);
        }
    }
    public Optional<Consultant> findById(Long id){
        return consultantRepository.findById(id);
    }
    public List<Consultant> findAll(){
        return consultantRepository.findAll();
    }
    public boolean isValid4Test(Consultant consultant){
        int isApproved = consultant.getIsApproved();
        return isApproved != 0;
    }

    @Transactional
    public void updateNumberOfUsedCareerTests(Long id) {
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        int used = consultant.getNumberOfUsedCarerTests();
        consultant.setNumberOfUsedCarerTests(used+1);
        int available = consultant.getNumberOfAvailableCareerTests();
        consultant.setNumberOfAvailableCareerTests(available-1);
    }

    @Transactional
    public void updateNumberOfUsedMrAndersonTests(Long id) {
        Consultant consultant = consultantRepository.findById(id).orElse(null);
        int used = consultant.getNumberOfUsedMrAndersonTests();
        consultant.setNumberOfUsedMrAndersonTests(used+1);
        int available = consultant.getNumberOfAvailableMrAndersonTests();
        consultant.setNumberOfAvailableMrAndersonTests(available-1);
    }
}
