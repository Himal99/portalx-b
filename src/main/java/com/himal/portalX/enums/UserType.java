package com.himal.portalX.enums;

/**
 * @author Himal Rai on 2/4/2022
 */
public enum UserType {
    EMPLOYEE("Employee"),EMPLOYER("Employer");

    private String value;
    UserType(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
