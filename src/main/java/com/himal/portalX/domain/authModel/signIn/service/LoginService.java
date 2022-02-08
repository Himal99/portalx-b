package com.himal.portalX.domain.authModel.signIn.service;

import com.himal.portalX.domain.authModel.AuthDto;
import com.himal.portalX.domain.user.entity.User;

/**
 * @author Himal Rai on 2/4/2022
 */
public interface LoginService {
    AuthDto login(User user);
}
