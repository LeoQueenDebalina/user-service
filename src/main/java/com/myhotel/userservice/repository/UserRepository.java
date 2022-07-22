package com.myhotel.userservice.repository;

import com.myhotel.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query("select case when count(u)>0 then true else false end from UserEntity u where u.userPhoneNumber = :n")
    public boolean ifExitsNumber(@Param("n") String number);

    @Query("select u from UserEntity u where u.userPhoneNumber = ?1")
    public List<UserEntity> selectAllByNumber(String number);

    @Query("select u.uuid from UserEntity u where u.userPhoneNumber = ?1")
    public String getUserIdByNumber(String number);
}
