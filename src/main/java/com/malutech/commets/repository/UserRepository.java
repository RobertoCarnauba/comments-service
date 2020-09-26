package com.malutech.commets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.malutech.commets.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
