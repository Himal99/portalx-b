package com.himal.portalX.domain.authModel.signUp.service;

import com.himal.portalX.base.exceptions.MyException;
import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.user.service.UserServiceImpl;
import com.himal.portalX.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Himal Rai on 2/4/2022
 */
@Service
public class SignUpServiceImpl implements SignUpService{


    private final UserServiceImpl userService;

    @Autowired
    public SignUpServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public User signUp(User user) {
        try {
            if(Objects.isNull(user.getEmail()) || Objects.isNull(user.getPassword())) {
                throw new MyException(HttpStatus.INTERNAL_SERVER_ERROR, MyException.EMPTY_FIELD);
            }
            if (Objects.isNull(user.getUserType()))
                user.setUserType(UserType.EMPLOYEE);
            return userService.saveUser(user);
        }catch (NullPointerException e){
                throw new MyException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}
