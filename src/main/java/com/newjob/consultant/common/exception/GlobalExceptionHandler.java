package com.newjob.consultant.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(NotFoundException.class)
    public String NotFoundException(NotFoundException ex) {
        log.warn(ex.getErrorCode().getMessage());
        return "error/not_found.html";
    }

}
