package com.newjob.consultant.entity.consultant.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
