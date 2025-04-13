package com.dev.ops.service.interfaces;

import com.dev.ops.dto.appoinment.AppoinmentDto;
import com.dev.ops.dto.user.UserDto;
import com.dev.ops.model.document.Appoinment;
import com.dev.ops.model.document.User;

public interface UserInterfaceService {

  public Appoinment createAppoinment(AppoinmentDto appoinmentDtoj);

  public User createUser(UserDto userDto);
}
