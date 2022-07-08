package com.myhotel.userservice.service;

import com.myhotel.userservice.entity.UserDatabase;
import com.myhotel.userservice.model.InputModel;
import com.myhotel.userservice.model.OutputModel;

import java.util.List;

public interface UserService {
    public String saveUser(InputModel inputModel);
    public String updateUser(InputModel inputModel);
}
