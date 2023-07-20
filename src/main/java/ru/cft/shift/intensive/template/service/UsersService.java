package ru.cft.shift.intensive.template.service;

import ru.cft.shift.intensive.template.dto.RegistrationUserDto;
import ru.cft.shift.intensive.template.dto.UserDto;
import ru.cft.shift.intensive.template.dto.UsernameDto;

import java.util.List;

public interface UsersService {
  List<UsernameDto> list();

  UserDto findByUsername(String username);

  String create(UserDto user);

  //UsernameDto registrationUser(RegistrationUserDto user);

  void delete(String username);
}
