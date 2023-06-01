package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiError handleException(Exception ex) {
        log.error("", ex);

        ApiError apiError = new ApiError();
        apiError.setErrorMessage(ex.getMessage());

        return apiError;
    }

}
