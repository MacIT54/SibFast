package ru.cft.shift.intensive.template.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.intensive.template.dto.AuthStatus;
import ru.cft.shift.intensive.template.dto.RegistrationUserDto;
import ru.cft.shift.intensive.template.dto.UserDto;
import ru.cft.shift.intensive.template.dto.UsernameDto;
import ru.cft.shift.intensive.template.service.UsersService;
import ru.cft.shift.intensive.template.service.impl.UsersServiceImpl;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("auth")
public class AuthController {

  private final UsersServiceImpl usersService;

  @Autowired
  public AuthController(UsersServiceImpl usersService) {
    this.usersService = usersService;
  }


  @PostMapping("registration")
  public ResponseEntity<String> createUser(@RequestBody @Valid UserDto newUser) {
    return ResponseEntity.ok(this.usersService.create(newUser));
  }

  @Operation(summary = "api.admin.delete.operation.summary")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "api.admin.delete.api-responses.200.description"),
          @ApiResponse(responseCode = "404", description = "api.admin.delete.api-responses.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))}),
          @ApiResponse(responseCode = "500", description = "api.cookbook.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
  }) // Регистрация пользователя

  @GetMapping("success")
  public ResponseEntity<AuthStatus> success() {
    return ResponseEntity.ok(new AuthStatus("OK"));
  }

  @GetMapping("failed")
  public ResponseEntity<AuthStatus> failed() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthStatus("FAILED"));
  }
}
