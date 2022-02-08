package com.himal.portalX.domain.vacancy.dto;

import com.himal.portalX.domain.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Himal Rai on 2/5/2022
 */
@Getter
@Setter
@NoArgsConstructor
@Data
public class GetVacancyDto {
    private String vacancyTitle;
    private String vacancyDetail;
    private String noOfVacancy;
    private String vacancyPost;
    private String salary;
    private String vacancyType;
    private String jsonData;
    private String companyAddress;
    private String phoneNo;
    private String about;
    private String data;
    private String companyName;
    private String companyEmail;
    private List<AppliedUserDto> appliedUser;

}
