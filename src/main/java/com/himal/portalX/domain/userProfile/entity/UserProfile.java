package com.himal.portalX.domain.userProfile.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.himal.portalX.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Himal Rai on 2/4/2022
 */
@Entity
@Table(name = "user_profile")
@Setter
@Getter
public class UserProfile {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String contactNo;
    private String about;
    private String data;


    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable=false)
    @OneToOne()
    private User user;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedAt = LocalDateTime.now();


}
