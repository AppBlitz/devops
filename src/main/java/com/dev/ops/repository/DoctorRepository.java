package com.dev.ops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.ops.model.document.Doctor;

public interface DoctorRepository extends MongoRepository<String, Doctor> {

}
