package com.dev.ops.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.ops.model.document.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findById(String idUser);
}
