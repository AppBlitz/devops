package com.dev.ops.dto.user;

import java.time.LocalDate;

import lombok.NonNull;

public record UserDto(@NonNull String nameUser, @NonNull String surnameUser, @NonNull String ni,
        @NonNull LocalDate dateOfBirth, int age) {
}
