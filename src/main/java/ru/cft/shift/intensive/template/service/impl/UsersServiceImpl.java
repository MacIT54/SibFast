package ru.cft.shift.intensive.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cft.shift.intensive.template.dto.RegistrationUserDto;
import ru.cft.shift.intensive.template.dto.UserDto;
import ru.cft.shift.intensive.template.dto.UsernameDto;
import ru.cft.shift.intensive.template.exception.UsernameNotFoundException;
import ru.cft.shift.intensive.template.repository.UsersRepository;
import ru.cft.shift.intensive.template.repository.entity.Users;
import ru.cft.shift.intensive.template.service.UsersService;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService, UserDetailsService {
  private final UsersRepository usersRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
    this.usersRepository = usersRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public List<UsernameDto> list() {
    return this.usersRepository.findAll().stream().map(users -> new UsernameDto(users.getUsername())).toList();
  }

  @Override
  public UserDto findByUsername(String username) {
    return this.usersRepository.findById(username)
        .map(user -> new UserDto(user.getUsername(), user.getFullName(), user.getPassword(), user.getRoles().toArray(String[]::new)))
        .orElseThrow(UsernameNotFoundException::new);
  }

  @Override
  public String create(UserDto user) {
    Users users = new Users(user.username(), user.fullName(), this.passwordEncoder.encode(user.password()), user.roles());
    this.usersRepository.save(users);
    return users.getFullName();
  }

//  @Override
//  public UsernameDto registrationUser(RegistrationUserDto user) {
//    Users users = new Users(user.username(), user.login(), this.passwordEncoder.encode(user.password()));
//    return new UsernameDto(this.usersRepository.save(users).getUsername());
//  }

  @Override
  public void delete(String username) {
    Users users = this.usersRepository.findById(username).orElseThrow(UsernameNotFoundException::new);
    this.usersRepository.delete(users);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
    UserDto userDto = findByUsername(username);
    return User.builder()
            .username(userDto.username())
            //.login(userDto.login())
            .password(userDto.password())
            .roles(userDto.roles())
            .build();
  }
}
