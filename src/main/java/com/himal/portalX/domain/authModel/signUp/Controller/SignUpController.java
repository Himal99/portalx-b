package com.himal.portalX.domain.authModel.signUp.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himal.portalX.base.exceptions.GlobalPortalException;
import com.himal.portalX.base.httpResponse.MyResponse;
import com.himal.portalX.base.exceptions.MyException;
import com.himal.portalX.domain.authModel.signUp.service.SignUpServiceImpl;
import com.himal.portalX.domain.user.dto.UserDto;
import com.himal.portalX.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.himal.portalX.base.urlPath.MyUrl.SIGNUP;

/**
 * @author Himal Rai on 2/4/2022
 */
@RestController
@RequestMapping(SIGNUP)
public class SignUpController extends GlobalPortalException {


    private final SignUpServiceImpl service;

    @Autowired
    public SignUpController(SignUpServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> userSignUp(@RequestBody UserDto userDto){

           ObjectMapper mapper = new ObjectMapper();
           User user = mapper.convertValue(userDto, User.class);
           return new MyResponse().successResponse(service.signUp(user));
    }
}
