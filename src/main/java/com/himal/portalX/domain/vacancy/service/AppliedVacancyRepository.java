package com.himal.portalX.domain.vacancy.service;

import com.himal.portalX.domain.vacancy.entity.AppliedVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Himal Rai on 2/5/2022
 */
@Repository
public interface AppliedVacancyRepository extends JpaRepository<AppliedVacancy, Long> {
    List<AppliedVacancy> findAllByVacancy_Id(Long id);
}
