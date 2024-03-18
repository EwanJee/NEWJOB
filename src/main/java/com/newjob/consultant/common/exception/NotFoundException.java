package com.newjob.consultant.common.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    private ErrorCode errorCode;
    public NotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
