package com.newjob.consultant.entity;

import com.newjob.consultant.repository.AdminRepository;
import com.newjob.consultant.repository.ConsultantRepository;
import com.newjob.consultant.service.AdminService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AdminTest {

    private AdminRepository adminRepository = mock(AdminRepository.class);
    private ConsultantRepository consultantRepository = mock(ConsultantRepository.class);
    private AdminService adminService = new AdminService(adminRepository,consultantRepository);

    @Test
    void 어드민_isAdmin이_잘_동작하는지(){
        //given
        String adminId = "not_admin";
        Admin admin = adminRepository.findAll().get(0);

        //given
        when(adminRepository.findAll())
                .thenReturn(List.of(admin));
        //when
        boolean isAdmin = adminService.isAdmin(adminId);

        //then
        Assertions.assertThat(isAdmin).isEqualTo(true);
    }
}