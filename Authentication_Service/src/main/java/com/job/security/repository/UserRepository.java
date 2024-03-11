package com.job.security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.job.security.model.Userinfo;

public interface UserRepository extends MongoRepository<Userinfo, Long> {

	Optional<Userinfo> findByUsername(String username);

}
