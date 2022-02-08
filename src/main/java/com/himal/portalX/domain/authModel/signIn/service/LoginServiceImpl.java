package com.himal.portalX.domain.authModel.signIn.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himal.portalX.base.exceptions.MyException;
import com.himal.portalX.base.userAccess.AccessProperties;
import com.himal.portalX.domain.authModel.AuthDto;
import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.user.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author Himal Rai on 2/4/2022
 */
@Service
public class LoginServiceImpl implements LoginService{


    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @Override
    public AuthDto login(User user) {
       try{
           User loggedUser = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
           if(Objects.isNull(loggedUser)){
              throw new MyException(HttpStatus.INTERNAL_SERVER_ERROR, MyException.LOGIN_FAILED);
           }
           httpSession.setAttribute("loggedInUser", loggedUser);
           AuthDto authDto = new AuthDto();
           authDto.setEmail(loggedUser.getEmail());
           authDto.setPassword(loggedUser.getPassword());
           authDto.setToken(AccessProperties.TOKEN(100));
           return authDto;
       }catch (MyException e){
           throw new MyException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
       }

    }
}
