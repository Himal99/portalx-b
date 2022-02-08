package com.himal.portalX.base.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Himal Rai on 2/6/2022
 */

@Setter
@Getter
public class MyException extends RuntimeException {

    static final long serialVersionUID = 1L;

    //    Error messages
    public static final String NULL_EMAIL = "email can't be null";
    public static final String NO_USER_FOUND = "user not found";
    public static final String INVALID_EMAIL = "invalid email";
    public static final String EMPTY_FIELD = "some field are null";
    public static final String LOGIN_FAILED = "email or password is wrong";


    private HttpStatus httpStatus;
    private String message;

    public MyException(HttpStatus httpStatus, String message) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
    }


}
