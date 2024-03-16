package com.newjob.consultant.admin;

import com.newjob.consultant.entity.Admin;
import com.newjob.consultant.entity.Consultant;
import com.newjob.consultant.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class AdminTests {
    @Autowired
    private AdminRepository adminRepository;
    @Test
    @DisplayName("어드민 레포지토리에서 첫번째 인덱스와 id가 1인 어드민의 id가 같은지 확인")
    public void test1(){
    }
    @Test
    void ei(){

    }
}
