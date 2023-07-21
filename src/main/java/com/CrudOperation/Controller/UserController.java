package com.CrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CrudOperation.Entity.User;
import com.CrudOperation.Service.Userservice;



@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private Userservice userService;
	
	@PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	@GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	 @GetMapping("/getAllUsers")
	    public ResponseEntity<List<User>> getAllUsers(){
	        List<User> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	 
	 @PutMapping("/updateUserDetail")
		public User updateParentDetail(@RequestBody User user) {

			return userService.updateUser(user);
		}
	 
	 @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId){
	        userService.deleteUser(userId);
	        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	    }
	
}
