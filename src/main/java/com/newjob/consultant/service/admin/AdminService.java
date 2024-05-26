package com.newjob.consultant.service.admin;

import com.newjob.consultant.repository.admin.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public boolean isAdmin(String id) {
        return adminRepository.existsById(id);
    }
}
