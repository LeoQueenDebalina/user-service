package com.myhotel.userservice.service;

import com.myhotel.userservice.entity.UserEntity;
import com.myhotel.userservice.model.InputRequest;
import com.myhotel.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private String message;
    @Autowired
    private UserRepository userRepository;

    public String saveUser(InputRequest inputRequest) {
        List list = Arrays.asList(inputRequest);
        UUID uuid = UUID.randomUUID();
        if(this.userRepository.findByByMNumber(inputRequest.getUserPh())){
            message = "Your account is already exist.";
        }else{
            List<UserEntity> data = (List<UserEntity>) list.stream().map(e-> UserEntity
                    .builder().userPh(inputRequest.getUserPh())
                    .uuid(String.valueOf(uuid))
                    .userName(inputRequest.getUserName())
                    .userAddress(inputRequest.getUserAddress())
                    .userDOB(inputRequest.getUserDOB())
                    .userEmail(inputRequest.getUserEmail())
                    .userGender(inputRequest.getUserGender())
                    .build()).collect(Collectors.toList());
            userRepository.saveAll(data);
            message = "your data are saved";
        }
        return message;
    }
    public String updateUser(InputRequest inputRequest) {
        List list = Arrays.asList(inputRequest);
        List<UserEntity> test = this.userRepository.selectAllByNumber(inputRequest.getUserPh());
        if(test.size() != 0) {
            for (UserEntity u : test) {
                List<UserEntity> data = (List<UserEntity>) list.stream().map(e-> UserEntity
                        .builder().userPh(inputRequest.getUserPh())
                        .uuid(u.getUuid())
                        .userName(inputRequest.getUserName())
                        .userAddress(inputRequest.getUserAddress())
                        .userDOB(inputRequest.getUserDOB())
                        .userEmail(inputRequest.getUserEmail())
                        .userGender(inputRequest.getUserGender())
                        .build()).collect(Collectors.toList());
                userRepository.saveAll(data);
                message = "your data are updated";
            }
        }else{
            message = "Your phone number not found.";
        }
        return message;
    }

    public String getUserIdByNumber(String number) {
        if (this.userRepository.findByByMNumber(number)) {
            return this.userRepository.getUserIdByNumber(number);
        }else{
            return  null;
        }
    }
}