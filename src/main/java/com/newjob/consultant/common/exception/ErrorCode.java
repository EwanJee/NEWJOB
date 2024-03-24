package com.newjob.consultant.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    CONSULTANT_NOT_FOUND(404, "CONSULTANT-ERR-404", "해당 컨설턴트를 찾을 수 없습니다"),
    CAREER_TEST_RESULT_NOT_FOUND(404,"CareerTestResult-ERR-404","해당 커리어 진단 리포트 결과를 찾을 수 없습니다"),
    ANDERSON_TEST_RESULT_NOT_FOUND(404,"CareerTestResult-ERR-404","해당 퇴직 진단 리포트 결과를 찾을 수 없습니다");

    private final int status;
    private final String errorCode;
    private final String message;
}
