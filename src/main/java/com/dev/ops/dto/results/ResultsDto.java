package com.dev.ops.dto.results;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.NonNull;

public record ResultsDto(
    @Id
    String id,

    @NonNull
    String nameAppoinment,

    @NonNull
    LocalDate dateAppoinment,

    @NonNull
    String nameDoctor,

    @NonNull
    String recommendations,

    @NonNull
    String TypeTest,

    @NonNull
    String site,

    @NonNull
    String ParametersDoctors
) {
    
}
