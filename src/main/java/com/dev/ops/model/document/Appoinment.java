package com.dev.ops.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

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
public class Appoinment {

  @Id
  String id;

  @NonNull
  String nameDoctor;

  @NonNull
  LocalDate dateAppointment;

  @NonNull
  LocalTime timeAppoinment;

}
