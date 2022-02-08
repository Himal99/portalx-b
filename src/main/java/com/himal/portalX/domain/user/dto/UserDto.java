package com.himal.portalX.domain.user.dto;

import com.himal.portalX.enums.UserType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Himal Rai on 2/4/2022
 */
@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String userName;
    private UserType userType;

}
