package com.himal.portalX.domain.user.entity;

import com.himal.portalX.enums.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author Himal Rai on 2/4/2022
 */
@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Email(message = "email can't be null")
    @NotNull(message = "email can't be null")
    private String email;
    private String password;
    private String userName;
    private UserType userType = UserType.EMPLOYEE;


}
