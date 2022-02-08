package com.himal.portalX.base.httpResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Himal Rai on 2/4/2022
 */
@Setter
@Getter
public class ResponseDto {
    private String message;


    private Object detail;

    private final LocalDateTime timestamp = LocalDateTime.now();

    private int code;

    private HttpStatus httpStatus;
}
