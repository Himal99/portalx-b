package com.himal.portalX.domain.userProfile.service;

import com.himal.portalX.domain.userProfile.dto.CompanyProfileDto;
import com.himal.portalX.domain.userProfile.entity.UserProfile;

/**
 * @author Himal Rai on 2/5/2022
 */
public interface UserProfileService {
   CompanyProfileDto getCurrentUserProfile();
   CompanyProfileDto getProfileByUserId(Long id);
}
