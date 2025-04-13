package com.dev.ops.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ops.dto.appoinment.AppoinmentDto;
import com.dev.ops.dto.user.UserDto;
import com.dev.ops.model.document.Appoinment;
import com.dev.ops.model.document.User;
import com.dev.ops.model.enums.NumStateAppoinment;
import com.dev.ops.repository.AppoinmentRepository;
import com.dev.ops.repository.UserRepository;
import com.dev.ops.service.interfaces.UserInterfaceService;
import com.dev.ops.validators.Validators;

@Service
public class UserService implements UserInterfaceService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppoinmentRepository appoinmentRepository;

    @Autowired
    Validators validators;

    @Override
    public Appoinment createAppoinment(AppoinmentDto appoinmentDto) {
        Appoinment appoinment = Appoinment.builder()
                .nameDoctor(appoinmentDto.nameDoctor())
                .name(appoinmentDto.name())
                .dateOfBirth(appoinmentDto.dateOfBirth())
                .dateAppointment(appoinmentDto.dateAppoinment())
                .age(appoinmentDto.age())
                .ni(appoinmentDto.ni())
                .timeAppoinment(appoinmentDto.timeAppoinment())
                .surname(appoinmentDto.surname())
                .state(NumStateAppoinment.APPROVED)
                .build();
        Appoinment appoi = appoinmentRepository.save(appoinment);
        return validators.saveAppointment(appoi, appoinmentDto.idUser());
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = User.builder()
                .surname(userDto.nameUser())
                .ni(userDto.ni())
                .dateOfBirth(userDto.dateOfBirth())
                .name(userDto.nameUser())
                .build();
        return userRepository.save(user);
    }

}
