package com.myhotel.userservice.controller;


import com.myhotel.userservice.model.InputModel;
import com.myhotel.userservice.model.OutputModel;
import com.myhotel.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController{
   @Autowired
   private UserService userService;
  @PostMapping("/register")
  public OutputModel registerUser(@RequestBody InputModel inputModel){
     return new OutputModel(this.userService.saveUser(inputModel));
  }
  @PostMapping("/user")
  public OutputModel updateUser(@RequestBody InputModel inputModel){
     return new OutputModel(this.userService.updateUser(inputModel));
  }

}
