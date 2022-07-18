package com.myhotel.userservice.controller;


import com.myhotel.userservice.model.InputRequest;
import com.myhotel.userservice.model.OutputResponse;
import com.myhotel.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user/v1")
public class UserController{
   @Autowired
   private UserService userService;
  @PostMapping("/register")
  public OutputResponse registerUser(@RequestBody InputRequest inputRequest){
     return new OutputResponse(this.userService.saveUser(inputRequest));
  }
  @PostMapping("/user")
  public OutputResponse updateUser(@RequestBody InputRequest inputRequest){
     return new OutputResponse(this.userService.updateUser(inputRequest));
  }
  @GetMapping("/getuserbynumber/{number}")
    public String getUserIdByNumber(@PathVariable String number){
      return this.userService.getUserIdByNumber(number);
  }

}
