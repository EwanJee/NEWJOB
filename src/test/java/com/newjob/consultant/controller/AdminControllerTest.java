package com.newjob.consultant.controller;

import com.newjob.consultant.repository.AdminRepository;
import com.newjob.consultant.repository.CareerTestResultRepository;
import com.newjob.consultant.repository.ConsultantRepository;
import com.newjob.consultant.repository.MrAndersonTestResultRepository;
import com.newjob.consultant.service.AdminService;
import com.newjob.consultant.service.ConsultantService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
@WebMvcTest(AdminController.class)
class AdminControllerTest {
    private AdminRepository adminRepository = mock(AdminRepository.class);
    private ConsultantRepository consultantRepository = mock(ConsultantRepository.class);
    private AdminService adminService = new AdminService(adminRepository,consultantRepository);
    private CareerTestResultRepository careerTestResultRepository = mock(CareerTestResultRepository.class);
    private MrAndersonTestResultRepository mrAndersonTestResultRepository = mock(MrAndersonTestResultRepository.class);
    private ConsultantService consultantService = new ConsultantService(consultantRepository,careerTestResultRepository,mrAndersonTestResultRepository);

    private MockMvc mockMvc;
    @Test
    void isAdmin() {
        //given
        //when
//        mockMvc.perform(MockMvcRequestBuilders.get("/admin/list")
//                .contentType())
        //then
    }

    @Test
    void consultantList() {
    }
}