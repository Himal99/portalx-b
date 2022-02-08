package com.himal.portalX.domain.authModel;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Himal Rai on 2/4/2022
 */
@Setter
@Getter
public class AuthDto {

    private String email;
    private String password;
    private String token;

}
