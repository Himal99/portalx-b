package com.himal.portalX.domain.userProfile.service;

import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.userProfile.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Himal Rai on 2/4/2022
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findUserProfileByUser(User user);
    UserProfile findUserProfileByUser_Id(Long id);
}
