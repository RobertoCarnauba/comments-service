package com.malutech.commets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.malutech.commets.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
}
