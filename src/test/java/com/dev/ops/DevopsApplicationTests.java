package com.dev.ops;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.test.context.SpringBootTest;

import com.dev.ops.dto.appoinment.AppoinmentDto;
import com.dev.ops.dto.user.UserDto;
import org.junit.jupiter.api.BeforeEach;

import jakarta.validation.*;
import java.util.Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DevopsApplicationTests {
  
  private Validator validator;

  // Método setup() para inicializar el validador de Jakarta**
  @BeforeEach
  public void setup() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
  }

  // Prueba parametrizada para verificar que el nombre no esté vacío o tenga espacios en blanco**
  @ParameterizedTest
  @ValueSource(strings = {"", "   ", "\t"})
  void shouldFailWhenNameIsInvalid(String name) {
    UserDto user = new UserDto(name, "Perez", "123", LocalDate.of(2000, 1, 1), 24);
    Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
    assertFalse(violations.isEmpty(), "Nombre inválido: [" + name + "]");
  }

  // Prueba parametrizada para verificar que el apellido no esté vacío o tenga espacios en blanco**
  @ParameterizedTest
  @ValueSource(strings = {"", "   ", "\t"})
  void shouldFailWhenSurnameIsInvalid(String surname) {
    UserDto user = new UserDto("Juan", surname, "123", LocalDate.of(2000, 1, 1), 24);
    Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
    assertFalse(violations.isEmpty(), "Apellido inválido: [" + surname + "]");
  }

  // Prueba parametrizada para verificar que el NI no esté vacío o tenga espacios en blanco**
  @ParameterizedTest
  @ValueSource(strings = {"", "   ", "\t"})
  void shouldFailWhenNIIsInvalid(String ni) {
    UserDto user = new UserDto("Juan", "Perez", ni, LocalDate.of(2000, 1, 1), 24);
    Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
    assertFalse(violations.isEmpty(), "NI inválido: [" + ni + "]");
  }

  // Prueba parametrizada para verificar que la fecha de nacimiento no sea futura**
  @ParameterizedTest
  @ValueSource(strings = {"2025-11-11"})
  void shouldFailWhenBirthDateIsInvalid(String date) {
    LocalDate birthDate = date.isEmpty() ? null : LocalDate.parse(date);
    UserDto user = new UserDto("Juan", "Perez", "123", birthDate, 24);
    Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
    assertFalse(violations.isEmpty(), "Fecha de nacimiento inválida: [" + date + "]");
  }

  // Prueba parametrizada para verificar que la edad no sea negativa**
  @ParameterizedTest
  @ValueSource(ints = {-1})
  void shouldFailWhenAgeIsInvalid(int age) {
    UserDto user = new UserDto("Juan", "Perez", "123", LocalDate.of(2000, 1, 1), age);
    Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
    assertFalse(violations.isEmpty(), "Edad inválida: [" + age + "]");
  }

  // Pruebas para el DTO de citas (AppointmentDto)

  // Prueba parametrizada para verificar que el ID de usuario no esté vacío o tenga espacios en blanco**
  @ParameterizedTest
  @ValueSource(strings = {"", " "})
  void shouldFailWhenIdUserIsBlank(String idUser) {
      AppoinmentDto appointment = new AppoinmentDto(idUser, "John", "Doe", LocalDate.of(1990, 5, 20), 30, "12345", "Dr. Smith", LocalDate.of(2025, 5, 15), LocalTime.of(9, 0));

      Set<ConstraintViolation<AppoinmentDto>> violations = validator.validate(appointment);
      assertFalse(violations.isEmpty());
  }

  // Prueba parametrizada con @CsvSource para múltiples parámetros: verifica los campos de ID, nombre y apellido**
  @ParameterizedTest
  @CsvSource({
      "'', John, Doe",  // ID vacío, nombre y apellido válidos
      "'123', '', Doe", // ID válido, nombre vacío
      "'123', 'John', ''" // ID y nombre válidos, apellido vacío
  })
  void shouldFailWhenFieldsAreBlank(String idUser, String name, String surname) {
      AppoinmentDto appointment = new AppoinmentDto(idUser, name, surname, LocalDate.of(1990, 5, 20), 30, "12345", "Dr. Smith", LocalDate.of(2025, 5, 15), LocalTime.of(9, 0));

      Set<ConstraintViolation<AppoinmentDto>> violations = validator.validate(appointment);
      assertFalse(violations.isEmpty());
  }

  // Prueba parametrizada con @CsvSource para comprobar si la fecha de nacimiento es futura o pasada**
  @ParameterizedTest
  @CsvSource({
      "2027-01-01, true",  // Fecha futura (no válida)
      "2020-01-01, false"  // Fecha pasada (válida)
  })
  void shouldFailWhenDateOfBirthIsFuture(String dateOfBirth, boolean shouldFail) {
      AppoinmentDto appointment = new AppoinmentDto("1", "John", "Doe", LocalDate.parse(dateOfBirth), 30, "12345", "Dr. Smith", LocalDate.of(2025, 5, 15), LocalTime.of(9, 0));

      Set<ConstraintViolation<AppoinmentDto>> violations = validator.validate(appointment);

      if (shouldFail) {
          assertFalse(violations.isEmpty());
      } else {
          assertTrue(violations.isEmpty());
      }
  }

  // Prueba parametrizada con @CsvSource para verificar que la edad no sea negativa**
  @ParameterizedTest
  @CsvSource({
      "-1, true",  // Edad negativa (no válida)
      "25, false"  // Edad válida
  })
  void shouldFailWhenAgeIsNegative(int age, boolean shouldFail) {
      AppoinmentDto appointment = new AppoinmentDto("1", "John", "Doe", LocalDate.of(1990, 5, 20), age, "12345", "Dr. Smith", LocalDate.of(2025, 5, 15), LocalTime.of(9, 0));

      Set<ConstraintViolation<AppoinmentDto>> violations = validator.validate(appointment);

      if (shouldFail) {
          assertFalse(violations.isEmpty());
      } else {
          assertTrue(violations.isEmpty());
      }
  }

  // Prueba parametrizada con @CsvSource para verificar que la fecha de la cita no sea futura**
  @ParameterizedTest
  @CsvSource({
      "'2025-05-15', false",  // Fecha de cita futura (válida)
      "'2022-05-15', true"  // Fecha de cita pasada (no válida)
  })
  void shouldFailWhenDateAppoinmentIsInFuture(String dateAppoinment, boolean shouldFail) {
      AppoinmentDto appointment = new AppoinmentDto("1", "John", "Doe", LocalDate.of(1990, 5, 20), 30, "12345", "Dr. Smith", LocalDate.parse(dateAppoinment), LocalTime.of(9, 0));

      Set<ConstraintViolation<AppoinmentDto>> violations = validator.validate(appointment);

      if (shouldFail) {
          assertFalse(violations.isEmpty());
      } else {
          assertTrue(violations.isEmpty());
      }
  }
}
