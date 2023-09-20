package com.newjob.consultant.service;

import com.newjob.consultant.entity.CareerTestResult;
import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.repository.CareerTestResultRepository;
import com.newjob.consultant.repository.ConsultantRepository;
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

    @Transactional
    public Long join(Consultant consultant){
        isValidated(consultant);
        consultantRepository.save(consultant);
        return consultant.getId();
    }
    @Transactional
    public void addCareerTest(Long consultantId, CareerTestResult careerTestResult){
        Optional<Consultant> optionalConsultant = consultantRepository.findById(consultantId);
        Consultant consultant = optionalConsultant.orElse(null);
        if(consultant != null){
            consultant.getCareerTestResultList().add(careerTestResult);
        }
    }
    public Consultant findByConsultant(String skey, String consultantName){
        Optional<Consultant> consultant = consultantRepository.findBySkeyAndName(skey,consultantName);
        return (Consultant) consultant.orElse(null);}
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
}
