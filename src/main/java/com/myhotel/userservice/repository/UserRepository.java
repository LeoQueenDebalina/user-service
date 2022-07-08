package com.myhotel.userservice.repository;

import com.myhotel.userservice.entity.UserDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  UserRepository extends JpaRepository<UserDatabase, String> {
     @Query("select case when count(u)>0 then true else false end from UserDatabase u where u.userPh = :n")
    public boolean findByByMNumber(@Param("n") String number);
     @Query("select u from UserDatabase u where u.userPh = ?1")
    public List<UserDatabase> selectAllByNumber(String number);
}
