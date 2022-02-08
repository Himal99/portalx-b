package com.himal.portalX.domain.user.service;

import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.vacancy.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Himal Rai on 2/4/2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    @Query(value = " select s from Vacancy s join AppliedVacancy c on s.id = c.vacancy.id " +
           "where c.user.id =:id")
    List<Vacancy> getAppliedVacancy(Long id);

}
