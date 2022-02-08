package com.himal.portalX.domain.user.service;

import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.userProfile.entity.UserProfile;
import com.himal.portalX.domain.userProfile.service.UserProfileRepository;
import com.himal.portalX.domain.vacancy.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Himal Rai on 2/4/2022
 */
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final UserProfileRepository userProfileRepository;

    private final HttpSession httpSession;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserProfileRepository userProfileRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.httpSession = httpSession;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        UserProfile userProfile = new UserProfile();
        User savedUSer = userRepository.save(user);
        userProfile.setUser(savedUSer);
        userProfileRepository.save(userProfile);
        return savedUSer;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return (User) httpSession.getAttribute("loggedInUser");
    }

    @Override
    public List<Vacancy> appliedVacancy() {
        return userRepository.getAppliedVacancy(getCurrentUser().getId());
    }
}
