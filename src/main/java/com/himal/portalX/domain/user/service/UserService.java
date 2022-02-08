package com.himal.portalX.domain.user.service;

import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.vacancy.entity.Vacancy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Himal Rai on 2/4/2022
 */

@Service
@Component("userServiceComponent")
public interface UserService{
    User saveUser(User user);
    User getById(Long id);
    List<User> getAll();
    User getCurrentUser();

    List<Vacancy> appliedVacancy();

}
