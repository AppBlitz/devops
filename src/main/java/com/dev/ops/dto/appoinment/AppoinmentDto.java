package com.dev.ops.dto.appoinment;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.NonNull;

public record AppoinmentDto(@NonNull String idUser, @NonNull String name, @NonNull String surname,
                @NonNull LocalDate dateOfBirth,
                int age, @NonNull String ni, @NonNull String nameDoctor, @NonNull LocalDate dateAppoinment,
                @NonNull LocalTime timeAppoinment) {

}
