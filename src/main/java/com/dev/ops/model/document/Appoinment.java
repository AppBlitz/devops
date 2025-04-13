package com.dev.ops.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import com.dev.ops.model.enums.NumStateAppoinment;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;

@Document("appointment")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appoinment {

  @Id
  String id;

  @NonNull
  String name;

  @NonNull
  String ni;

  @NonNull
  String surname;

  @NonNull
  String nameDoctor;

  @NonNull
  LocalDate dateAppointment;

  @NonNull
  LocalTime timeAppoinment;

  @NonNull
  LocalDate dateOfBirth;

  int age;

  NumStateAppoinment state;
}
