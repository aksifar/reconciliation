package com.prudential.datalake.reconciliation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prudential.datalake.reconciliation.model.User;
import com.prudential.datalake.reconciliation.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable("userId") String userId){
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			return new ResponseEntity<>(user.get(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		User save = userRepository.save(user);
		if(save != null)
			return  new ResponseEntity<>(save,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
}
