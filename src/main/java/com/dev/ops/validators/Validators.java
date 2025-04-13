package com.dev.ops.validators;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.ops.exceptions.user.ExceptionUserExits;
import com.dev.ops.model.document.Appoinment;
import com.dev.ops.model.document.User;
import com.dev.ops.repository.UserRepository;

@Component
public class Validators {

  @Autowired
  UserRepository userRepository;

  public User searchUser(String idUser) {
    return userRepository.findById(idUser)
        .orElseThrow(() -> new ExceptionUserExits("The user was not found"));
  }

  public Appoinment saveAppointment(Appoinment appoinment, String idUser) {
    User user = searchUser(idUser);
    user.setAppoinment(addAppointment(user.getAppoinment(), appoinment.getId()));
    userRepository.save(user);
    return appoinment;
  }

  public ArrayList<String> addAppointment(ArrayList<String> appoinments, String idAppoinment) {
    appoinments.add(idAppoinment);
    return appoinments;
  }

}
