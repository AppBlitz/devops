package com.dev.ops.model.document;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
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

  @Builder.Default
  ArrayList<String> appoinment = new ArrayList<>();

  @Builder.Default
  ArrayList<String> resultsDoctor = new ArrayList<>();
}
