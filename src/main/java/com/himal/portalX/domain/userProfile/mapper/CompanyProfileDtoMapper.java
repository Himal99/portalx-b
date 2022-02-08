package com.himal.portalX.domain.userProfile.mapper;

import com.himal.portalX.base.mapper.BaseMapper;
import com.himal.portalX.domain.userProfile.dto.CompanyProfileDto;
import com.himal.portalX.domain.userProfile.entity.UserProfile;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Himal Rai on 2/5/2022
 */
@Mapper(componentModel = "spring")
public abstract class CompanyProfileDtoMapper implements BaseMapper<UserProfile, CompanyProfileDto> {
    @Override
    @Mapping(source = "user.userName", target = "name")
    @Mapping(source = "user.email", target = "email")
    public abstract CompanyProfileDto mapEntityToDto(UserProfile s);


    @Override
    @Mapping(source = "name", target = "user.userName")
    @Mapping(source = "email", target = "user.email")
    public abstract UserProfile mapDtoToEntity(CompanyProfileDto e);

    @Override
    public abstract List<UserProfile> mapDtoListToEntityList(List<CompanyProfileDto> d);
}
