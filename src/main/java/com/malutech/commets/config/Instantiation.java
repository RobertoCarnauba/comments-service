package com.malutech.commets.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.malutech.commets.domain.Post;
import com.malutech.commets.domain.User;
import com.malutech.commets.dto.AuthorDTO;
import com.malutech.commets.repository.PostRepository;
import com.malutech.commets.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User beto = new User(null, "Roberto Carnaúba Dias", "betorobertodias@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex, bob, beto));
		
		Post post1 =  new Post(null, sdf.parse("26/09/2020"), "Make A diferentece", "É um fato estabelecido há muito tempo", new AuthorDTO(maria));
		Post post2 =  new Post(null, sdf.parse("29/01/2020"), "Make", "É um fato estabelecido há muito tempo", new AuthorDTO(maria));
		Post post3 =  new Post(null, sdf.parse("27/09/2020"), "Same thing else", "É um fato estabelecido há muito tempo", new AuthorDTO(beto));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
	}

}
