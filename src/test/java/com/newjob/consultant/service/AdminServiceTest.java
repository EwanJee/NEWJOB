package com.newjob.consultant.service;

import com.newjob.consultant.entity.Admin;
import com.newjob.consultant.repository.AdminRepository;
import com.newjob.consultant.repository.ConsultantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdminServiceTest {

    private AdminRepository adminRepository = mock(AdminRepository.class);
    private ConsultantRepository consultantRepository = mock(ConsultantRepository.class);
    private AdminService adminService = new AdminService(adminRepository,consultantRepository);

    @Test
    void 어드민_isAdmin이_잘_동작하는지(){
        //given
        String adminId = "not_admin";
        Admin admin = new Admin(1L,adminId,"1234");

        //given
        when(adminRepository.findAll())
                .thenReturn(List.of(admin));
        //when
        boolean isAdmin = adminService.isAdmin(adminId);

        //then
        Assertions.assertThat(isAdmin).isEqualTo(true);
    }
}