package com.himal.portalX.domain.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himal.portalX.base.httpResponse.MyResponse;
import com.himal.portalX.domain.user.dto.UserDto;
import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.himal.portalX.base.urlPath.MyUrl.*;

/**
 * @author Himal Rai on 2/4/2022
 */
@RestController
@RequestMapping(USER)
@CrossOrigin("*")
public class UserController {


    private final UserServiceImpl service;

    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }


    @PostMapping()
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(userDto, User.class);
        return new MyResponse().successResponse(service.saveUser(user));
    }


    @GetMapping(BY_ID)
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new MyResponse().successResponse(service.getById(id));
    }

    @GetMapping(APPLIED_VACANCY)
    public ResponseEntity<?> getMyAppliedVacancy(){
        return new MyResponse().successResponse(service.appliedVacancy());
    }
}
