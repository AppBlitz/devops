package com.dev.ops.controller.interfaces;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dev.ops.dto.appoinment.AppoinmentDto;
import com.dev.ops.dto.user.UserDto;
import com.dev.ops.model.document.Appoinment;
import com.dev.ops.model.document.ResultsDoctor;
import com.dev.ops.model.document.User;

public interface UserInterface {

  public Appoinment createDate(@RequestBody() AppoinmentDto appoinmentDto);

  public User createUser(@RequestBody() UserDto userDto);

  public ResultsDoctor getResults(@PathVariable String nameAppointment,@PathVariable LocalDate dateAppointment);
  

}
