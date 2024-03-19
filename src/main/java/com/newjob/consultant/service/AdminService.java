package com.newjob.consultant.service;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
import com.newjob.consultant.entity.Admin;
import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.repository.AdminRepository;
import com.newjob.consultant.repository.ConsultantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Consultant Not Found", ErrorCode.CONSULTANT_NOT_FOUND));
        consultant.setNumberOfAvailableMrAndersonTests(anderson);
        consultant.setNumberOfAvailableCareerTests(career);
        consultant.setApproved(approved);
    }
    public void deleteForm(Long id){
        consultantRepository.deleteById(id);
    }
}
