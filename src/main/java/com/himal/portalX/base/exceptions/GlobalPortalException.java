package com.himal.portalX.base.exceptions;

import com.himal.portalX.base.httpResponse.MyResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Himal Rai on 2/6/2022
 */
@ControllerAdvice
public class GlobalPortalException extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timeStamp", System.currentTimeMillis());
        body.put("status", status.value());

        List<String> errors= ex.getBindingResult()
                .getFieldErrors().stream().map(x-> x.getDefaultMessage()).
                collect(Collectors.toList());
        body.put("errors", errors);

        return new ResponseEntity<Object>(body, status);

    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> emptyInputHandler(MyException myException){
        return new MyResponse().failResponseWithStatus(myException.getHttpStatus(), myException.getMessage());
    }

}
