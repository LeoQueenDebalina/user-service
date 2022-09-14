package com.myhotel.userservice;

import com.myhotel.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Test
	void contextLoads() {
		System.out.println(userRepository.existsUserEntityByUserPhoneNumber("8420126789"));
	}

}
