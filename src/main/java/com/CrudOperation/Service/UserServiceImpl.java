package com.CrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CrudOperation.Entity.User;
import com.CrudOperation.Repository.UserRepo;

@Service
public class UserServiceImpl implements Userservice {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {

		return userRepo.save(user);
	}

	public User getUserById(int userId) {

		return userRepo.findById(userId).orElse(null);

	}

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {

		User existingUser = userRepo.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAge(user.getAge());

		User updatedUser = userRepo.save(existingUser);
		return updatedUser;

	}

	@Override
	public String deleteUser(int userId) {

		userRepo.deleteById(userId);
		return "Record deleted Successfully" + userId;

	}

}
