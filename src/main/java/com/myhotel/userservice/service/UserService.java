package com.myhotel.userservice.service;

import com.myhotel.userservice.entity.UserEntity;
import com.myhotel.userservice.exception.NoDataFoundException;
import com.myhotel.userservice.model.InputRequest;
import com.myhotel.userservice.model.OutputResponse;
import com.myhotel.userservice.model.ViewInputRequest;
import com.myhotel.userservice.model.ViewOutputResponse;
import com.myhotel.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public OutputResponse saveUser(InputRequest inputRequest) {
        UUID uuid = UUID.randomUUID();
        if (this.userRepository.existsUserEntityByUserPhoneNumber(inputRequest.getUserPhoneNumber())) {
            return new OutputResponse(true, "Your account is already exist.");
        } else {
            userRepository.save(UserEntity
                    .builder().userPhoneNumber(inputRequest.getUserPhoneNumber())
                    .uuid(String.valueOf(uuid))
                    .userFullName(inputRequest.getUserFullName())
                    .userAddress(inputRequest.getUserAddress())
                    .userDOB(inputRequest.getUserDOB())
                    .userEmailId(inputRequest.getUserEmailId())
                    .userGender(inputRequest.getUserGender())
                    .build());
            return new OutputResponse(false, "your data are saved");
        }
    }

    public OutputResponse updateUser(InputRequest inputRequest) {
        UserEntity test = this.userRepository.findByUserPhoneNumber(inputRequest.getUserPhoneNumber());
        if (test != null) {
            userRepository.save(UserEntity
                    .builder().userPhoneNumber(inputRequest.getUserPhoneNumber())
                    .uuid(test.getUuid())
                    .userFullName(inputRequest.getUserFullName())
                    .userAddress(inputRequest.getUserAddress())
                    .userDOB(inputRequest.getUserDOB())
                    .userEmailId(inputRequest.getUserEmailId())
                    .userGender(inputRequest.getUserGender())
                    .build());
            return new OutputResponse(false, "Your data are updated");
        } else {
            return new OutputResponse(true, "Your phone number not found.");
        }
    }

    public String getUserIdByNumber(String number) {
        if (this.userRepository.existsUserEntityByUserPhoneNumber(number)) {
            return this.userRepository.findByUserPhoneNumber(number).getUuid();
        } else {
            return null;
        }
    }

    public ViewOutputResponse getUserDetailsByNumber(ViewInputRequest viewInputRequest) throws NoDataFoundException {
        UserEntity data = this.userRepository.findByUserPhoneNumber(viewInputRequest.getUserPhoneNumber());
        if (data != null) {
            return new ViewOutputResponse(data.getUserPhoneNumber(), data.getUserFullName(), data.getUserEmailId(), data.getUserGender(), data.getUserDOB(), data.getUserAddress());
        } else {
            throw new NoDataFoundException("Your account Not Found.");
        }
    }

    public ResponseEntity<String> deleteById(String number) {
        try {
            this.userRepository.deleteById(userRepository.findByUserPhoneNumber(number).getUuid());
            return new ResponseEntity<>("Your account is Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Your account is not found.", HttpStatus.BAD_GATEWAY);
        }
    }
}