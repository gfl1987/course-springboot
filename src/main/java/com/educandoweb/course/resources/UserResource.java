package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController 
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() { //método que acessa os usuarios
		User u = new User(1L, "Guilherme", "guilherme.leite1987@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
