package com.newjob.consultant.service;

import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.repository.AdminRepository;
import com.newjob.consultant.repository.ConsultantRepository;
import com.newjob.consultant.repository.JdbcAdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    private final JdbcAdminRepository jdbcAdminRepository;
    private final AdminRepository adminRepository;
    private final ConsultantRepository consultantRepository;
    public boolean isAdmin(String id){
        return adminRepository.existsById(id);
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
