package com.dev.ops.dto.appoinment;

import java.util.Locale;

import lombok.NonNull;

public record AppoinmentDto(@NonNull String name, @NonNull String surname, @NonNull Locale dateOfBirth,
    int age, @NonNull String ni) {

}
