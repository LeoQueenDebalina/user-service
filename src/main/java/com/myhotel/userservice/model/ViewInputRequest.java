package com.myhotel.userservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewInputRequest {
    @NotNull(message = "Field cannot be null")
    @Size(min = 10, max = 10, message = "Enter 10 digit mobile number")
    @Pattern(regexp = "^([1-9]\\d*|0)$", message = "Only content number")
    @ApiModelProperty(value = "Phone Number")
    private String userPhoneNumber;
}
