package com.himal.portalX.base.httpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author Himal Rai on 2/4/2022
 */
public class MyResponse {
    public ResponseEntity<ResponseDto> successResponse(Object o) {
        ResponseDto r = new ResponseDto();
        r.setDetail(o);
        r.setMessage("SUCCESS");
        r.setCode(HttpStatus.OK.value());
        r.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> successResponseStatus(Object o, HttpStatus httpStatus) {
        ResponseDto r = new ResponseDto();
        r.setDetail(o);
        r.setMessage("SUCCESS");
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }

    public ResponseEntity<ResponseDto> successResponseStatusWithMessage(Object o, String message, HttpStatus httpStatus) {
        ResponseDto r = new ResponseDto();
        r.setDetail(o);
        r.setMessage(message);
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }

    public ResponseEntity<ResponseDto> validationFailed(List<ObjectError> errors) {
        ResponseDto r = new ResponseDto();
        r.setDetail(errors);

        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseDto> failResponseBadRequest(String message) {
        ResponseDto r = new ResponseDto();
        r.setMessage(message);
        r.setCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ResponseDto> failResponseWithStatus(HttpStatus httpStatus, String message) {
        ResponseDto r = new ResponseDto();
        r.setMessage(message);
        r.setCode(httpStatus.value());
        r.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(r, httpStatus);
    }

    public ResponseEntity<ResponseDto> failResponseWithStatusAndBody(HttpStatus httpStatus, String message, Object body) {
        ResponseDto r = new ResponseDto();
        r.setMessage(message);
        r.setDetail(body);
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }
}
