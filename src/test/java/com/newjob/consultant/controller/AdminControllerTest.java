package com.newjob.consultant.controller;

import com.newjob.consultant.repository.AdminRepository;
import com.newjob.consultant.repository.CareerTestResultRepository;
import com.newjob.consultant.repository.ConsultantRepository;
import com.newjob.consultant.repository.MrAndersonTestResultRepository;
import com.newjob.consultant.service.AdminService;
import com.newjob.consultant.service.ConsultantService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@WebMvcTest(AdminController.class)
class AdminControllerTest {
    private final AdminRepository adminRepository = mock(AdminRepository.class);
    private final ConsultantRepository consultantRepository = mock(ConsultantRepository.class);
    private final AdminService adminService = new AdminService(adminRepository,consultantRepository);
    private final CareerTestResultRepository careerTestResultRepository = mock(CareerTestResultRepository.class);
    private final MrAndersonTestResultRepository mrAndersonTestResultRepository = mock(MrAndersonTestResultRepository.class);
    private final ConsultantService consultantService = new ConsultantService(consultantRepository,careerTestResultRepository,mrAndersonTestResultRepository);

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