package ru.cft.shift.intensive.template.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RegistrationUserDto(@NotEmpty @Size(min = 3, max = 50) String username,
                      @NotEmpty @Size(min = 3, max = 50) String login,
                      @NotEmpty @Size(min = 3, max = 50) String password) {
}
