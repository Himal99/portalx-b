package com.himal.portalX.domain.vacancy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.himal.portalX.domain.user.entity.User;
import com.himal.portalX.domain.userProfile.entity.UserProfile;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Himal Rai on 2/4/2022
 */
@Entity
@Table(name = "vacancy")
@Setter
@Getter
public class Vacancy {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String vacancyTitle;
    private String vacancyDetail;
    private String noOfVacancy;
    private String vacancyPost;
    private String salary;
    private String vacancyType;
    @Column(length = 10000)
    private String jsonData;

    @OneToOne
    @JoinColumn(name = "userProfile_id",referencedColumnName = "id")
    private UserProfile companyProfile;


    @JoinTable(name = "user_vacancy",
            joinColumns = {
                    @JoinColumn(name = "vacancy_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",updatable = true)})
    @ManyToMany()
    @JsonIgnore
    private List<User> users;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedAt = LocalDateTime.now();

}
