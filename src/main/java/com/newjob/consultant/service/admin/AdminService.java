package com.newjob.consultant.service.admin;

import com.newjob.consultant.entity.consultant.Consultant;
import com.newjob.consultant.repository.admin.AdminRepository;
import com.newjob.consultant.repository.consultant.ConsultantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final ConsultantRepository consultantRepository;
    public boolean isAdmin(String id){
        return (1 == adminRepository.findAll()
                .stream()
                .filter(e -> e.getId().equals(id))
                .count());
    }
    @Transactional
    public void updateForm(Long id, int anderson, int career, int approved) {
        Optional<Consultant> optionalConsultant = consultantRepository.findById(id);
        Consultant consultant = optionalConsultant.orElse(null);
        consultant.setNumberOfAvailableMrAndersonTests(anderson);
        consultant.setNumberOfAvailableCareerTests(career);
        consultant.setApproved(approved);
    }
    public void deleteForm(Long id){
        consultantRepository.deleteById(id);
    }
}
