package com.newjob.consultant.common.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private String code;
}
