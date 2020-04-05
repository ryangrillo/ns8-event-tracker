package com.ryangrillo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import com.ryangrillo.exception.ApiRuntimeException;
import com.ryangrillo.model.User;
import com.ryangrillo.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserControllerTest {

	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userController = new UserController(userService);
	}

	@Test
	public void test_create_user() throws Exception {
		User mockExpectedUser = new User("ry@g.com", "password", "888-888-8888");
		when(userService.createUser(any())).thenReturn(mockExpectedUser);
		User actualUser = userController.createUser(new User("ry@g.com", "password", "888-888-8888"));
		assertEquals(mockExpectedUser.getPhone(), actualUser.getPhone());
		assertEquals(mockExpectedUser.getEmail(), actualUser.getEmail());
		assertEquals(mockExpectedUser.getPassword(), actualUser.getPassword());
		
	}
	
	@Test(expected = ApiRuntimeException.class)
	public void test_create_user_throws_exception() throws Exception {
		User mockExpectedUser = new User("ry@g.com", "password", "888-888-8888");
		when(userService.createUser(any())).thenThrow(new ApiRuntimeException(""));
		User actualUser = userController.createUser(new User("ry@g.com", "password", "888-888-8888"));
		assertEquals(mockExpectedUser.getPhone(), actualUser.getPhone());
		assertEquals(mockExpectedUser.getEmail(), actualUser.getEmail());
		assertEquals(mockExpectedUser.getPassword(), actualUser.getPassword());
		
	}

}

