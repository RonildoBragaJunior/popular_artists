package com.redballoon.service;

import com.redballoon.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
