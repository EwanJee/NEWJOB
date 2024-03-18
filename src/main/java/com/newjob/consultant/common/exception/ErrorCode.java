package com.newjob.consultant.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND(404, "COMMON-ERR-404", "PAGE NOT FOUND");

    private int status;
    private String errorCode;
    private String message;
}
