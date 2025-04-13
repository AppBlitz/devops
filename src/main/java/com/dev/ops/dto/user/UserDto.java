package com.dev.ops.dto.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.NonNull;

public record UserDto(@NonNull @NotBlank(message = "nombre no puede estar vacio") String nameUser, 
                        @NonNull @NotBlank(message = "apellido no puede estar vacio") String surnameUser, 
                        @NonNull @NotBlank(message = "ni no puede estar vacio") String ni,
                        @NonNull @Past(message = "la fecha no puede ser futura") @NotNull(message = "la fecha no puede estar vacia") LocalDate dateOfBirth, 
                        @Min(value = 0,message = "la edad no puede ser negativa") int age) {
}
