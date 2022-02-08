package com.himal.portalX.domain.authModel.signIn.controller;

import com.himal.portalX.base.httpResponse.MyResponse;
import com.himal.portalX.domain.authModel.AuthDto;
import com.himal.portalX.domain.authModel.signIn.service.LoginServiceImpl;
import com.himal.portalX.domain.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.himal.portalX.base.urlPath.MyUrl.LOGIN;

/**
 * @author Himal Rai on 2/4/2022
 */
@RestController
@RequestMapping(LOGIN)
@CrossOrigin("*")
public class LoginController {

    private final LoginServiceImpl service;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

   @Autowired
    public LoginController(LoginServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> userLogin(@RequestBody AuthDto authDto){
        logger.info("data::{}",authDto);
        User user = new User();
        user.setEmail(authDto.getEmail());
        user.setPassword(authDto.getPassword());
        return new MyResponse().successResponse(service.login(user));
    }
}
