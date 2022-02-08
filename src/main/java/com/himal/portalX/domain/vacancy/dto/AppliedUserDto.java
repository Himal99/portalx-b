package com.himal.portalX.domain.vacancy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Himal Rai on 2/5/2022
 */
@Setter
@Getter
@Data
public class AppliedUserDto {
    private Long id;
    private String email;
    private String name;
}
