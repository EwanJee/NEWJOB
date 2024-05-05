package com.newjob.consultant.controller.consultant.dto;

import com.newjob.consultant.entity.consultant.Consultant;
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

    public static ConsultantForm of(Consultant consultant){
        return ConsultantForm.builder()
                .id(consultant.getId())
                .email(consultant.getEmail())
                .name(consultant.getName())
                .phoneNumber(consultant.getPhoneNumber())
                .company(consultant.getCompany())
                .numberOfUsedCareerTests(consultant.getNumberOfUsedCarerTests())
                .numberOfAvailableCareerTests(consultant.getNumberOfAvailableCareerTests())
                .numberOfUsedMrAndersonTests(consultant.getNumberOfUsedMrAndersonTests())
                .numberOfAvailableMrAndersonTests(consultant.getNumberOfAvailableMrAndersonTests())
                .isApproved(consultant.getIsApproved())
                .build();
    }
    public boolean isValid4Test(){
        return isApproved != 0;
    }
    public static String directToMrAndersonView(ConsultantForm consultantForm){
        if (!consultantForm.isValid4Test()) {
            return "careerTest/false";
        } else if (consultantForm.getNumberOfAvailableMrAndersonTests() <= 0) {
            return "careerTest/invalid";
        } else {
            return "mrAnderson/andersonValid";
        }
    }
    public static String directToCareerView(ConsultantForm consultantForm){
        if (!consultantForm.isValid4Test()) {
            return "careerTest/false";
        } else if (consultantForm.getNumberOfAvailableCareerTests() <= 0) {
            return "careerTest/invalid";
        } else {
            return "careerTest/valid";
        }
    }
}
