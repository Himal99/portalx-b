package com.himal.portalX.domain.userProfile.controller;

import com.himal.portalX.base.httpResponse.MyResponse;
import com.himal.portalX.domain.userProfile.service.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.himal.portalX.base.urlPath.MyUrl.*;

/**
 * @author Himal Rai on 2/5/2022
 */
@RestController
@RequestMapping(PROFILE)
public class ProfileController {

    private  final UserProfileServiceImpl service;

    @Autowired
    public ProfileController(UserProfileServiceImpl service) {
        this.service = service;
    }

    @GetMapping(CURRENT_USER_PROFILE)
    public ResponseEntity<?> getProfile(){
        return new MyResponse().successResponse(service.getCurrentUserProfile());
    }

    @GetMapping(BY_ID)
    public ResponseEntity<?> profileById(@PathVariable("id") Long id){

        return new MyResponse().successResponse(service.getProfileByUserId(id));
    }

}
