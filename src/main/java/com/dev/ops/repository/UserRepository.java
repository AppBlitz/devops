package com.dev.ops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.ops.model.document.User;

public interface UserRepository extends MongoRepository<String, User> {

}
