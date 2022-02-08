package com.himal.portalX.domain.vacancy.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.user.service.UserServiceImpl;
import com.himal.portalX.domain.userProfile.entity.UserProfile;
import com.himal.portalX.domain.userProfile.service.UserProfileRepository;
import com.himal.portalX.domain.vacancy.dto.AppliedUserDto;
import com.himal.portalX.domain.vacancy.dto.GetVacancyDto;
import com.himal.portalX.domain.vacancy.entity.AppliedVacancy;
import com.himal.portalX.domain.vacancy.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Himal Rai on 2/4/2022
 */
@Service
public class VacancyServiceImpl implements VacancyService{


    private final VacancyRepository repository;

    private final UserServiceImpl userService;

    private final UserProfileRepository userProfileRepository;

    private final AppliedVacancyRepository appliedVacancyRepository;

    @Autowired
    public VacancyServiceImpl(VacancyRepository repository, UserServiceImpl userService, UserProfileRepository userProfileRepository,
                              AppliedVacancyRepository appliedVacancyRepository) {
        this.repository = repository;
        this.userService = userService;
        this.userProfileRepository = userProfileRepository;
        this.appliedVacancyRepository = appliedVacancyRepository;
    }

    @Override
    public Vacancy postVacancy(Vacancy vacancy) {
        List<User> u= new ArrayList<>();
        u.add(getCurrentUser());
        vacancy.setUsers(u);
        vacancy.setCompanyProfile(userProfileRepository.findUserProfileByUser(getCurrentUser()));
        return repository.save(vacancy);
    }

    @Override
    public Optional<Vacancy> getVacancyById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<GetVacancyDto> getByCompany(UserProfile userProfile) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vacancy> vacancies = repository.findAllByCompanyProfile(userProfileRepository.findUserProfileByUser(getCurrentUser()));
        List<GetVacancyDto> getVacancyDtos = new ArrayList<>();
        vacancies.forEach(v->{
            GetVacancyDto getVacancyDto = new GetVacancyDto();
            getVacancyDto.setVacancyTitle(v.getVacancyTitle());
            getVacancyDto.setNoOfVacancy(v.getNoOfVacancy());
            getVacancyDto.setVacancyDetail(v.getVacancyDetail());
            getVacancyDto.setSalary(v.getSalary());
            getVacancyDto.setJsonData(v.getJsonData());
          List<AppliedVacancy> appliedVacancies =  appliedVacancyRepository.findAllByVacancy_Id(v.getId());
                    if(!Objects.isNull(appliedVacancies)){
                        List<AppliedUserDto> user = new ArrayList<>();
                       appliedVacancies.forEach(a->{
                       AppliedUserDto appliedUserDto =new AppliedUserDto();
                       appliedUserDto.setId(a.getUser().getId());
                       appliedUserDto.setEmail(a.getUser().getEmail());
                       appliedUserDto.setName(a.getUser().getUserName());
                           user.add(appliedUserDto);
                       });
                       getVacancyDto.setAppliedUser(user);
                    }
            getVacancyDtos.add(getVacancyDto);
        });

        return getVacancyDtos;
    }

    @Override
    public List<Vacancy> getAllVacancy() {
        return repository.findAll();
    }

    @Override
    public List<AppliedVacancy> getAllAppliedUser(Long id) {
        return appliedVacancyRepository.findAllByVacancy_Id(id);
    }

    @Override
    public AppliedVacancy applyVacancy(Long userId, Long vacancyId) {
        AppliedVacancy appliedVacancy = new AppliedVacancy();
        appliedVacancy.setVacancy(repository.getById(vacancyId));
        appliedVacancy.setUser(userService.getById(userId));
      return   appliedVacancyRepository.save(appliedVacancy);
    }

    User getCurrentUser(){
        return userService.getCurrentUser();
    }
}
