package com.newjob.consultant.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public ModelAndView NotFoundException(NotFoundException ex){
        log.warn(ex.getErrorCode().getMessage());
        ModelAndView mav = new ModelAndView();
        mav.addObject("ex",ex.getErrorCode());
        mav.setViewName("/error/not_found");
        return mav;
    }
}
