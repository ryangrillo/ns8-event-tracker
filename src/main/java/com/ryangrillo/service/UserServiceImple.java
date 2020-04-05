package com.ryangrillo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ryangrillo.constants.Constants;
import com.ryangrillo.exception.ApiRuntimeException;
import com.ryangrillo.model.User;

@Service
public class UserServiceImple implements UserService {

	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public User createUser(User user) {
		if (users.stream().anyMatch(p -> p.getEmail().equalsIgnoreCase(user.getEmail()))) {
			throw new ApiRuntimeException(Constants.USER_WITH_EMAIL + user.getEmail() + Constants.ALREADY_EXISTS);
		} else {
			users.add(user);
			setUsers(users);
			return user;

		}
	}
}
