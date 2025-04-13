package com.dev.ops.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.ops.model.document.ResultsDoctor;

public interface ResultsDoctorRepository extends MongoRepository<ResultsDoctor, String> {

    List<ResultsDoctor> findBynameAppoinment(String nameAppoinment);

    List<ResultsDoctor> findBydateAppoinment(LocalDate dateAppoinment);

    

}
