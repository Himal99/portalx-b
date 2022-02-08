package com.himal.portalX.domain.vacancy.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.himal.portalX.base.httpResponse.MyResponse;
import com.himal.portalX.domain.vacancy.dto.VacancyDto;
import com.himal.portalX.domain.vacancy.entity.Vacancy;
import com.himal.portalX.domain.vacancy.service.VacancyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.himal.portalX.base.urlPath.MyUrl.*;

/**
 * @author Himal Rai on 2/4/2022
 */
@RestController
@RequestMapping(VACANCY)
public class VacancyController {

    private final VacancyServiceImpl service;

    @Autowired
    public VacancyController(VacancyServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addVacancy(@RequestBody VacancyDto vacancyDto){
        Vacancy vacancy = new ObjectMapper().convertValue(vacancyDto, Vacancy.class);

        return new MyResponse().successResponse(service.postVacancy(vacancy));
    }

    @GetMapping(VACANCY_BY_COMPANY)
    public ResponseEntity<?> getByCompany(){
        return new MyResponse().successResponse(service.getByCompany(null));
    }


    @GetMapping(VACANCY_APPLIED_USER)
    private ResponseEntity<?> getAppliedUserByVacancyId(@PathVariable("id") Long id){
        return new MyResponse().successResponse(service.getAllAppliedUser(id));
    }

    @PostMapping(APPLY_VACANCY)
    private ResponseEntity<?> applyVacancy(@PathVariable("userId") Long userId,
                                           @PathVariable("vacancyId") Long vacancyId){


        return new MyResponse().successResponse(service.applyVacancy(userId, vacancyId));
    }

}
