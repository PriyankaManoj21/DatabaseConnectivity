package com.example.databaseconnection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userrepo;
	
	@RequestMapping(value="/add" ,method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User user){
		System.out.println(user);
		userrepo.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/get" ,method = RequestMethod.GET)
	public ResponseEntity<List<User>> get(){
		
		List<User> user = userrepo.findAll();
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
		
	}

	@RequestMapping(value="/addusers", method= RequestMethod.POST)
	public ResponseEntity<List<User>> saveUsers(@RequestBody List<User> Users){
		userrepo.saveAll(Users);
		
		return new ResponseEntity<List<User>>(HttpStatus.CREATED);
		
	}
}
