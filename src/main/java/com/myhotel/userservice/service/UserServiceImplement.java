package com.myhotel.userservice.service;

import com.myhotel.userservice.entity.UserDatabase;
import com.myhotel.userservice.model.InputModel;
import com.myhotel.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {
    private String massage;
    @Autowired
    private UserRepository userRepository;
        UUID uuid = UUID.randomUUID();

    @Override
    public String saveUser(InputModel inputModel) {
        List list = Arrays.asList(inputModel);
        if(this.userRepository.findByByMNumber(inputModel.getUserPh())){
            massage = "Your account is already exist.";
        }else{
            List<UserDatabase> data = (List<UserDatabase>) list.stream().map(e->UserDatabase
                    .builder().userPh(inputModel.getUserPh())
                    .uuid(String.valueOf(uuid))
                    .userName(inputModel.getUserName())
                    .userAddress(inputModel.getUserAddress())
                    .userDOB(inputModel.getUserDOB())
                    .userEmail(inputModel.getUserEmail())
                    .userGender(inputModel.getUserGender())
                    .build()).collect(Collectors.toList());
            userRepository.saveAll(data);
            massage = "your data are saved";
        }
        return massage;
    }
    public String updateUser(InputModel inputModel) {
        List list = Arrays.asList(inputModel);
        List<UserDatabase> test = this.userRepository.selectAllByNumber(inputModel.getUserPh());
        if(test.size() != 0) {
            for (UserDatabase u : test) {
                List<UserDatabase> data = (List<UserDatabase>) list.stream().map(e->UserDatabase
                        .builder().userPh(inputModel.getUserPh())
                        .uuid(u.getUuid())
                        .userName(inputModel.getUserName())
                        .userAddress(inputModel.getUserAddress())
                        .userDOB(inputModel.getUserDOB())
                        .userEmail(inputModel.getUserEmail())
                        .userGender(inputModel.getUserGender())
                        .build()).collect(Collectors.toList());
                userRepository.saveAll(data);
                massage = "your data are updated";
            }
        }else{
            massage = "Your ph no not found.";
        }
        return massage;
    }
}