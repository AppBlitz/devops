package com.dev.ops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.ops.model.document.ResultsDoctor;

public interface ResulsDoctor extends MongoRepository<String, ResultsDoctor> {

}
