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
        if (this.userRepository.ifExitsNumber(inputRequest.getUserPhoneNumber())) {
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
        List<UserEntity> test = this.userRepository.selectAllByNumber(inputRequest.getUserPhoneNumber());
        if (test.size() != 0) {
            for (UserEntity u : test) {
                userRepository.save(UserEntity
                        .builder().userPhoneNumber(inputRequest.getUserPhoneNumber())
                        .uuid(u.getUuid())
                        .userFullName(inputRequest.getUserFullName())
                        .userAddress(inputRequest.getUserAddress())
                        .userDOB(inputRequest.getUserDOB())
                        .userEmailId(inputRequest.getUserEmailId())
                        .userGender(inputRequest.getUserGender())
                        .build());
                return new OutputResponse(false, "Your data are updated");
            }
        } else {
            return new OutputResponse(true, "Your phone number not found.");
        }
        return new OutputResponse(true, "Fall to update.");
    }

    public String getUserIdByNumber(String number) {
        if (this.userRepository.ifExitsNumber(number)) {
            return this.userRepository.getUserIdByNumber(number);
        } else {
            return null;
        }
    }

    public ViewOutputResponse getUserDetailsByNumber(ViewInputRequest viewInputRequest) throws NoDataFoundException {
        Optional<UserEntity> data = this.userRepository.findById(viewInputRequest.getUserPhoneNumber());
        if (data.isPresent()) {
            return new ViewOutputResponse(data.get().getUserPhoneNumber(), data.get().getUserFullName(), data.get().getUserEmailId(), data.get().getUserGender(), data.get().getUserDOB(), data.get().getUserAddress());
        } else {
            throw new NoDataFoundException("Your account Not Found.");
        }
    }

    public ResponseEntity<String> deleteById(String number) {
        try {
            this.userRepository.deleteById(number);
            return new ResponseEntity<>("Your account is Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Your account is not found.", HttpStatus.BAD_GATEWAY);
        }
    }
}