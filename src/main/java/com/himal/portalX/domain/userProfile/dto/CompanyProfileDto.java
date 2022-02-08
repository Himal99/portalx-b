package com.himal.portalX.domain.userProfile.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Himal Rai on 2/5/2022
 */
@Setter
@Getter
@Data
public class CompanyProfileDto {
    private String address;
    private String contactNo;
    private String about;
    private String data;
    private String email;
    private String name;

}
