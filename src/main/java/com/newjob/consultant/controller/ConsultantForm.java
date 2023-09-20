package com.newjob.consultant.controller;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultantForm {
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String password;
    private String company; //중경카 회사 소속
    private int numberOfUsedCareerTests;
    private int numberOfAvailableCareerTests;
    private int numberOfUsedMrAndersonTests;
    private int numberOfAvailableMrAndersonTests;
    private int isApproved;
}
