package com.dev.ops.controller.interfaces;

import org.springframework.web.bind.annotation.RequestBody;

import com.dev.ops.dto.results.ResultsDto;
import com.dev.ops.model.document.ResultsDoctor;

public interface ResultsInterface {

    public ResultsDoctor createResults(@RequestBody() ResultsDto dto );
}
