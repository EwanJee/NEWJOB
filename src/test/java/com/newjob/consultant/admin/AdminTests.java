package com.newjob.consultant.admin;

import com.newjob.consultant.entity.Admin;
import com.newjob.consultant.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AdminTests {
    @Autowired
    private AdminRepository adminRepository;
    public void test1(){
        //Given
        Admin admin = adminRepository.find

        //When

        //Then
    }
}
