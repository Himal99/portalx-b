package com.himal.portalX.base.urlPath;

import lombok.experimental.UtilityClass;

/**
 * @author Himal Rai on 2/5/2022
 */
@UtilityClass
public class MyUrl {

    public static final String VACANCY= "/v1/vacancy";
    public static final String VACANCY_BY_COMPANY="/byCompany";
    public static final String USER="/v1/users";
    public static final String BY_ID="/{id}";
    public static final String LOGIN="/v1/login";
    public static final String SIGNUP="/v1/signUp";
    public static final String PROFILE="/v1/profile";
    public static final String CURRENT_USER_PROFILE="/myProfile";
    public static final String VACANCY_APPLIED_USER="/appliedUser/{id}";
    public static final String APPLY_VACANCY="/apply/{userId}/{vacancyId}";
    public static final String APPLIED_VACANCY="/appliedVacancy";
    public static final String SIGN_OUT="/v1/signOut";




}
