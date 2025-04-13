package com.dev.ops.dto.appoinment;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.*;
import lombok.NonNull;

public record AppoinmentDto(@NonNull @NotBlank(message = "El ID del usuario no puede estar vacío") String idUser,  // ID del usuario
                            @NonNull @NotBlank(message = "El nombre no puede estar vacío") String name,  // Nombre del paciente
                            @NonNull @NotBlank(message = "El apellido no puede estar vacío") String surname,  // Apellido del paciente
                            @NonNull @NotNull(message = "La fecha de nacimiento no puede ser nula") @Past(message = "La fecha de nacimiento no puede ser futura") LocalDate dateOfBirth,  // Fecha de nacimiento
                            @Min(value = 0, message = "La edad no puede ser negativa") int age,  // Edad del paciente
                            @NonNull @NotBlank(message = "El NI no puede estar vacío") String ni,  // Número de identificación
                            @NonNull @NotBlank(message = "El nombre del doctor no puede estar vacío") String nameDoctor,  // Nombre del doctor
                            @NonNull @Future(message = "la cita no se puede acordar en el pasado") @NotNull(message = "La fecha de la cita no puede ser nula") LocalDate dateAppoinment,  // Fecha de la cita
                            @NonNull @NotNull(message = "La hora de la cita no puede ser nula") LocalTime timeAppoinment)   // Hora de la cita  
                            {

}
