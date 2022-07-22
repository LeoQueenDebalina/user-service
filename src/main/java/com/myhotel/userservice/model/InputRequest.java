package com.myhotel.userservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputRequest {
    @NotNull(message = "Field cannot be null")
    @Size(min = 10, max = 10, message = "Enter 10 digit mobile number")
    @Pattern(regexp = "^([1-9]\\d*|0)$", message = "Only content number")
    @ApiModelProperty(value = "Phone Number")
    private String userPhoneNumber;
    @NotNull(message = "Field cannot be null")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Only content character or space")
    @ApiModelProperty(value = "User Name")
    private String userFullName;
    @NotNull(message = "Field cannot be null")
    @Email(message = "invalid Email format")
    @ApiModelProperty(value = "Email Id")
    private String userEmailId;
    @NotNull(message = "Field cannot be null")
    @ApiModelProperty(value = "User Gender")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only content character")
    private String userGender;
    @NotNull(message = "Field cannot be null")
    @ApiModelProperty(value = "User Data Of Birth")
    @Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "Date if Birth Must Be YYYY-MM-DD Format")
    private String userDOB;
    @NotNull(message = "Field cannot be null")
    @ApiModelProperty(value = "User Address")
    private String userAddress;
}
