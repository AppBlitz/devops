package com.dev.ops.controller.implemtation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ops.controller.interfaces.ResultsInterface;
import com.dev.ops.service.implement.ResultsService;
import com.dev.ops.dto.results.ResultsDto;
import com.dev.ops.model.document.ResultsDoctor;

@RestController
@RequestMapping(value = "doctor")
public class ResultsController implements ResultsInterface {

  @Autowired
  ResultsService resultsService;

  @RequestMapping(value = "results", method = RequestMethod.POST)
  @Override
  public ResultsDoctor createResults(@RequestBody() ResultsDto dto ) {
    return resultsService.createResultsDoctor(dto);
  }

}