package com.newjob.consultant.service.admin;

import com.newjob.consultant.common.exception.ErrorCode;
import com.newjob.consultant.common.exception.NotFoundException;
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
    public void updateForm(Long id, int NumberOfAndersonTests, int NumberOfCareerTests, int approved) {
        Consultant consultant = consultantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CONSULTANT_NOT_FOUND));
        consultant.updateTestsAndApproved(NumberOfAndersonTests, NumberOfCareerTests, approved);
    }
    public void deleteForm(Long id){
        consultantRepository.deleteById(id);
    }
}
