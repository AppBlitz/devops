package com.dev.ops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.ops.model.document.Doctor;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

}
