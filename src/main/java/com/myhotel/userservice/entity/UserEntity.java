package com.myhotel.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
@Builder
public class UserEntity {
    @Id
    @Column(name = "userPhoneNumber",length = 100, nullable = false)
    private String userPhoneNumber;
    @Column(name = "uuid",length = 100, nullable = false)
    private String uuid;
    @Column(name = "userFullName",length = 100, nullable = false)
    private String userFullName;
    @Column(name = "userEmailId",length = 100, nullable = false)
    private String userEmailId;
    @Column(name = "userGender",length = 100, nullable = false)
    private String userGender;
    @Column(name = "userDOB",length = 100, nullable = false)
    private String userDOB;
    @Column(name = "userAddress",length = 100, nullable = false)
    private String userAddress;
}
