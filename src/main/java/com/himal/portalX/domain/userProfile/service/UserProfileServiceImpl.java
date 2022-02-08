package com.himal.portalX.domain.userProfile.service;

import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.user.service.UserServiceImpl;
import com.himal.portalX.domain.userProfile.dto.CompanyProfileDto;
import com.himal.portalX.domain.userProfile.mapper.CompanyProfileDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Himal Rai on 2/5/2022
 */
@Service
public class UserProfileServiceImpl implements UserProfileService{

    private final UserProfileRepository repository;
    private final CompanyProfileDtoMapper mapper;
    private final UserServiceImpl userService;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository repository, CompanyProfileDtoMapper mapper, UserServiceImpl userService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public CompanyProfileDto getCurrentUserProfile() {
        CompanyProfileDto companyProfileDto =
                mapper.mapEntityToDto(repository.findUserProfileByUser(getCurrentUser()));
        return companyProfileDto;
    }

    @Override
    public CompanyProfileDto getProfileByUserId(Long id) {
        CompanyProfileDto companyProfileDto =
                mapper.mapEntityToDto(repository.findUserProfileByUser_Id(id));
        return companyProfileDto;
    }

    private User getCurrentUser(){
        return userService.getCurrentUser();
    }
}
