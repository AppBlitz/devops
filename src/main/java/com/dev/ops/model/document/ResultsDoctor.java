package com.dev.ops.model.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document("resultsDoctor")
@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultsDoctor {

  @Id
  String id;

  @NonNull
  String nameAppoinment;

  @NonNull
  LocalDate dateAppoinment;

  @NonNull
  String nameDoc;

  @NonNull
  String recommendations;
  
  @NonNull
  String TypeTest;

  @NonNull
  String site ;

  @NonNull
  String ParametersDoctors;

  

}
