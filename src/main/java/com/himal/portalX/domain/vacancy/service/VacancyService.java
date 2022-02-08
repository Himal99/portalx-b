package com.himal.portalX.domain.vacancy.service;

import com.himal.portalX.domain.userProfile.entity.UserProfile;
import com.himal.portalX.domain.vacancy.dto.GetVacancyDto;
import com.himal.portalX.domain.vacancy.entity.AppliedVacancy;
import com.himal.portalX.domain.vacancy.entity.Vacancy;

import java.util.List;
import java.util.Optional;

/**
 * @author Himal Rai on 2/4/2022
 */
public interface VacancyService {
    Vacancy postVacancy(Vacancy vacancy);
    Optional<Vacancy> getVacancyById(Long id);
    List<GetVacancyDto> getByCompany(UserProfile userProfile);
    List<Vacancy> getAllVacancy();
    List<AppliedVacancy> getAllAppliedUser(Long id);
    AppliedVacancy applyVacancy(Long userId, Long vacancyId);
}
