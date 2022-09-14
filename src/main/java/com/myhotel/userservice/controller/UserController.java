package com.myhotel.userservice.controller;


import com.myhotel.userservice.exception.NoDataFoundException;
import com.myhotel.userservice.model.InputRequest;
import com.myhotel.userservice.model.OutputResponse;
import com.myhotel.userservice.model.ViewInputRequest;
import com.myhotel.userservice.model.ViewOutputResponse;
import com.myhotel.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/user/v1")
@Validated
@Api(value = "User Service")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "To register the user", notes = "To register the user")
    public OutputResponse registerUser(@Valid @RequestBody InputRequest inputRequest) {
        return this.userService.saveUser(inputRequest);
    }

    @PostMapping("/update")
    @ApiOperation(value = "To update the user", notes = "To update the user")
    public OutputResponse updateUser(@Valid @RequestBody InputRequest inputRequest) {
        return this.userService.updateUser(inputRequest);
    }

    @GetMapping("/viewUser")
    @ApiOperation(value = "To get the details", notes = "To get the details")
    public ViewOutputResponse getRegisterDetails(@Valid @RequestBody ViewInputRequest viewInputRequest) throws NoDataFoundException {
        return this.userService.getUserDetailsByNumber(viewInputRequest);
    }

    @DeleteMapping("/deleteByPhone/{number}")
    @ApiOperation(value = "To delete the user", notes = "To delete the user")
    public ResponseEntity<String> deleteById(@NotNull(message = "Field cannot be null") @PathVariable String number) {
        return this.userService.deleteById(number);
    }

    @ApiOperation(value = "", hidden = true)
    @GetMapping("/getUserByNumber/{number}")
    public String getUserIdByNumber(@NotNull(message = "Field cannot be null") @PathVariable String number) {
        return this.userService.getUserIdByNumber(number);
    }
}
