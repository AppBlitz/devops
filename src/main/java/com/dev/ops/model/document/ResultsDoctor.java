package com.dev.ops.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document("resultsDoctor")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultsDoctor {

  @Id
  String id;

}
