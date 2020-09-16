package com.luocj.springbootplayground.handlers;

import com.luocj.springbootplayground.vos.Result;
import com.luocj.springbootplayground.vos.ResultCode;
import io.jsonwebtoken.SignatureException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
public class SignatureExceptionHandler {
    @ExceptionHandler(SignatureException.class)
    public Result handleBindException(HttpServletRequest request, SignatureException exception){
        return Result.failure(ResultCode.FAILURE,exception.getMessage());
    }
}
