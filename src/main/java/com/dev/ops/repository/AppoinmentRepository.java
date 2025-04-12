package com.dev.ops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.ops.model.document.Appoinment;

public interface AppoinmentRepository extends MongoRepository<String, Appoinment> {

}
