package com.himal.portalX.domain.authModel.signOut;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.himal.portalX.base.urlPath.MyUrl.SIGN_OUT;

/**
 * @author Himal Rai on 2/6/2022
 */
@RestController
@RequestMapping(SIGN_OUT)
public class SignOutController {

    @PostMapping
    public void signOut(HttpSession httpSession){
        httpSession.removeAttribute("loggedInUser");
    }
}

