package com.capg.ems;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.ems.entities.User;
import com.capg.ems.repositories.ILoginRepository;
import com.capg.ems.service.ILoginServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	private ILoginServiceImpl loginService;
	
	@Mock
	private ILoginRepository loginRepository;
	
	@Test
	public void addNewUserTest()
	{
		User user=new User();
		user.setUserId(37);
		user.setPassword("Hello");
		user.setRole("CloudDeveloper");
		Mockito.when(loginRepository.save(user)).thenReturn(user);
	}
	
}
