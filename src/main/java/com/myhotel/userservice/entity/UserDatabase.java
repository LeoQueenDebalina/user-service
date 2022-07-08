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
public class UserDatabase {
    @Id
    @Column(name = "userPh",length = 100)
    private String userPh;
    @Column(name = "uuid",length = 100)
    private String uuid;
    @Column(name = "userName",length = 100)
    private String userName;
    @Column(name = "userEmail",length = 100)
    private String userEmail;
    @Column(name = "userGender",length = 100)
    private String userGender;
    @Column(name = "userDOB",length = 100)
    private String userDOB;
    @Column(name = "userAddress",length = 100)
    private String userAddress;
}
