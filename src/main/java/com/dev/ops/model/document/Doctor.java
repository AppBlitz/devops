package com.dev.ops.model.document;

import org.springframework.data.annotation.Id;

import com.dev.ops.model.enums.NumSpecialization;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

  @Id
  String id;

  @NonNull
  String nameDoctor;

  NumSpecialization specilization;

  String yokese;

}
