package com.luocj.springbootplayground.handlers;

import com.luocj.springbootplayground.vos.Result;
import com.luocj.springbootplayground.vos.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
public class BindExceptionHandler {
    @ExceptionHandler(BindException.class)
    public Result handleBindException(HttpServletRequest request, BindException exception){
        List<FieldError> allErrors = exception.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError errorMessage : allErrors) {
            sb.append(errorMessage.getField()).append(": ").append(errorMessage.getDefaultMessage()).append(", ");
        }
        System.out.println(sb.toString());
        return Result.failure(ResultCode.FAILURE,sb.toString());
    }
}
