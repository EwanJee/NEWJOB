package com.newjob.consultant.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    CONSULTANT_NOT_FOUND(404,"컨설턴트 정보 불일치","해당 컨설턴트를 찾을 수 없습니다"),
    CAREER_TEST_RESULT_NOT_FOUND(404, "커리어 진단 리포트 정보 불일치","해당 커리어 진단 리포트를 찾을 수 없습니다"),
    ANDERSON_TEST_RESULT_NOT_FOUND(404, "퇴직 진단 리포트 정보 불일치","해당 퇴직 진단 리포트를 찾을 수 없습니다"),
    LOGIN_FAILED(404, "회원 정보 불일치","비밀번호나 로그인이 잘못 되었습니다"),
    MEMBER_ALREADY_EXISTS(404, "회원 정보 중복", "해당 회원 정보가 이미 존재합니다");

    private final int status;
    private final String errorCode;
    private final String message;
}
