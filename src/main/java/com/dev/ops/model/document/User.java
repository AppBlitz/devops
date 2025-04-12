package com.dev.ops.model.document;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  String id;

  @NonNull
  String surname;

  @NonNull
  String name;

  @NonNull
  String ni;

  int age;

  @NonNull
  LocalDate dateOfBirth;

  ArrayList<String> appoinment = new ArrayList<>();
  ArrayList<String> resultsDoctor = new ArrayList<>();
}
