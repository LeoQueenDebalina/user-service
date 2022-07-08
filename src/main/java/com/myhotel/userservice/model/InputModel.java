package com.myhotel.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputModel {
    private String userPh;
    private String userName;
    private String userEmail;
    private String userGender;
    private String userDOB;
    private String userAddress;
}
