package com.himal.portalX.domain.vacancy.entity;

import com.himal.portalX.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Himal Rai on 2/5/2022
 */
@Entity
@Table(name = "applied_vacancy")
@Setter
@Getter
public class AppliedVacancy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "vacancy_id", nullable = false)
    private Vacancy vacancy;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
