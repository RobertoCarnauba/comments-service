package com.malutech.commets.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.malutech.commets.domain.User;
import com.malutech.commets.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User beto = new User(null, "Roberto Carnaúba Dias", "betorobertodias@gmail.com");
		
		
		repo.saveAll(Arrays.asList(maria,alex, bob, beto));
		
		
	}

}
