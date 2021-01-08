package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private List<User> database;

	public void createDatabase() {
		database = new ArrayList<>();
		
		User user = new User("mark",21,"mark@google.com");
		User user2 = new User("bob",21,"bob@google.com");
		User user3 = new User("savage",21,"savage@google.com");
		database.addAll(Arrays.asList(user,user2,user3));
	}


	// Obter usuarios - LISTA
	@GetMapping("/")
	public List<User> get() {
		this.createDatabase();

		return database;
	}

	// Obter usuarios - Receber um nome -> pesquisar no banco de dados
	@GetMapping("/findByName")
	public User findByName(@RequestParam String name) {
		this.createDatabase();
		
		// Buscar o usuario no banco de dados
		
		for (int i = 0; i < database.size(); i++) {
			User user = database.get(i);
			
			if(user.getName().equals(name)) {
				return user;
			}
		}
		
		return null;
	}
	
	
	// Criar usuarios
	@PostMapping
	public User post() {		
		return null;
	}

	// Editar usuarios
	@PutMapping
	public User put() {
		return null;
	}
	
	// DESAFIO - Criar metodo de deletar
	// Deletar usuarios

}
