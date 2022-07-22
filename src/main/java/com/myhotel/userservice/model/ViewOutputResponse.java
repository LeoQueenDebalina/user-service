package com.myhotel.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewOutputResponse {
    private String userPhoneNumber;
    private String userFullName;
    private String userEmailId;
    private String userGender;
    private String userDOB;
    private String userAddress;
}
