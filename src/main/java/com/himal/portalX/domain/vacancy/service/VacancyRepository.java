package com.himal.portalX.domain.vacancy.service;

import com.himal.portalX.domain.userProfile.entity.UserProfile;
import com.himal.portalX.domain.vacancy.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Himal Rai on 2/4/2022
 */
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAllByCompanyProfile(UserProfile userProfile);
}
