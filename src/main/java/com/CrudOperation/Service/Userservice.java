package com.CrudOperation.Service;

import java.util.List;

import com.CrudOperation.Entity.User;

public interface Userservice {
	

	User createUser(User user);

	User getUserById(int userId);

	List<User> getAllUsers();

	User updateUser(User user);

	String deleteUser(int userId);


}
