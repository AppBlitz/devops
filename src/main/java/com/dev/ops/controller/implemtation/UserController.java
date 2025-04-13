package com.dev.ops.controller.implemtation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ops.controller.interfaces.UserInterface;
import com.dev.ops.dto.appoinment.AppoinmentDto;
import com.dev.ops.dto.user.UserDto;
import com.dev.ops.model.document.Appoinment;
import com.dev.ops.model.document.ResultsDoctor;
import com.dev.ops.model.document.User;
import com.dev.ops.service.implement.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController implements UserInterface {

  @Autowired
  UserService userService;

  @RequestMapping(value = "appoinment", method = RequestMethod.POST)
  @Override
  public Appoinment createDate(@RequestBody() AppoinmentDto appoinmentDto) {
    return userService.createAppoinment(appoinmentDto);
  }

  @RequestMapping(value = "create")
  @Override
  public User createUser(UserDto userDto) {
    return userService.createUser(userDto);
  }

@RequestMapping(value = "/getResults/{nameAppointment}/{dateAppointment}", method = RequestMethod.GET)
@Override
public ResultsDoctor getResults(@PathVariable String nameAppointment,
                                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateAppointment) {
    return userService.getResults(nameAppointment, dateAppointment);
}

}
