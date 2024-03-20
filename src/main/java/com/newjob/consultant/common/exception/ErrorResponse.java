package com.newjob.consultant.common.exception;


public class ErrorResponse {
    private final int status;
    private final String message;
    private final String code;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getErrorCode();
    }
}
