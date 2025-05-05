package com.dev.ops.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ops.dto.results.ResultsDto;
import com.dev.ops.model.document.ResultsDoctor;
import com.dev.ops.repository.ResultsDoctorRepository;

@Service
public class ResultsService {

    @Autowired
    ResultsDoctorRepository resultsDoctorRepository;
    
        public ResultsDoctor createResultsDoctor(ResultsDto dto) {
        ResultsDoctor results = ResultsDoctor.builder()
                .nameAppoinment(dto.nameAppoinment())
                .dateAppoinment(dto.dateAppoinment())
                .nameDoc(dto.nameDoctor())
                .recommendations(dto.recommendations())
                .TypeTest(dto.TypeTest())
                .site(dto.site())
                .ParametersDoctors(dto.ParametersDoctors())
                .build();
        return resultsDoctorRepository.save(results);
    }

}
