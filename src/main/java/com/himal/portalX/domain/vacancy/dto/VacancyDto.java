package com.himal.portalX.domain.vacancy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Himal Rai on 2/4/2022
 */
@Setter
@Getter
@Data
public class VacancyDto {

    private String vacancyTitle;
    private String vacancyDetail;
    private String noOfVacancy;
    private String vacancyPost;
    private String salary;
    private String vacancyType;
    private String jsonData;
}
