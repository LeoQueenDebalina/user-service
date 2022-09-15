package com.myhotel.userservice.repository;

import com.myhotel.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsUserEntityByUserPhoneNumber(String number);

    UserEntity findByUserPhoneNumber(String userPhoneNumber);
}
