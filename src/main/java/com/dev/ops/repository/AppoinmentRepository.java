package com.dev.ops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.ops.model.document.Appoinment;

@Repository
public interface AppoinmentRepository extends MongoRepository<Appoinment, String> {

}
