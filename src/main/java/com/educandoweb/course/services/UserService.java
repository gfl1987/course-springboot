package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;  
	
	public List<User> findAll() { //método que retorna todos os usuarios do banco de dados
		return repository.findAll(); //retorna todo o repositório
	}
	
	public User findById(Long id) { //pesquisa um determinado usuario por Id
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) { //insere usuario
		return repository.save(obj);
	}
	
	public void delete(Long id) { //deleta usuario
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) { //atualiza um usuario por ID
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}
}