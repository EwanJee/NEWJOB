package com.newjob.consultant.service;

import com.newjob.consultant.repository.ConsultantRepository;
import com.newjob.consultant.repository.JdbcAdminRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class AdminServiceTest {
    private JdbcAdminRepository jdbcAdminRepository = mock(JdbcAdminRepository.class);
    private ConsultantRepository consultantRepository = mock(ConsultantRepository.class);
    private AdminService adminService = new AdminService(jdbcAdminRepository, consultantRepository);

    @Test
    void 어드민유저가_아닌_경우_구분할수있다() {
        // given
        String adminId = "not_admin";
        when(jdbcAdminRepository.checkById(any(String.class)))
                .thenReturn(false);

        // when
        boolean isAdmin = adminService.isAdmin(adminId);

        // then
        assertFalse(isAdmin);
        verify(jdbcAdminRepository, times(1)).checkById(any(String.class));
    }
}
