package ru.cft.shift.intensive.template.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.UserDto;
import ru.cft.shift.intensive.template.dto.UsernameDto;
import ru.cft.shift.intensive.template.service.UsersService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("admin")
@Tag(name = "api.admin.tag.name", description = "api.admin.tag.description")
public class AdminController {
  private final UsersService usersService;

  @Autowired
  public AdminController(UsersService usersService) {
    this.usersService = usersService;
  }

  @Operation(summary = "api.admin.users.operation.summary")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "api.admin.users.api-responses.200.description"),
      @ApiResponse(responseCode = "500", description = "api.cookbook.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
  })
  @GetMapping("users")
  public ResponseEntity<List<UsernameDto>> users() {
    return ResponseEntity.ok(this.usersService.list());
  }

  @Operation(summary = "api.admin.create.operation.summary")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "api.admin.create.api-responses.200.description"),
      @ApiResponse(responseCode = "500", description = "api.cookbook.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
  })
  @PostMapping("create")
  public ResponseEntity<String> createUser(@RequestBody @Valid UserDto user) {
    return ResponseEntity.ok(this.usersService.create(user));
  }

//  @Operation(summary = "api.admin.create.operation.summary")
//  @ApiResponses(value = {
//          @ApiResponse(responseCode = "200", description = "api.admin.create.api-responses.200.description"),
//          @ApiResponse(responseCode = "500", description = "api.cookbook.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
//  })
//  @PostMapping("newproduct")
//  public ResponseEntity<ProductDto> add(@RequestBody @Valid ProductDto product) {
//    return ResponseEntity.ok(this.usersService.create(product));
//  }

//  @Operation(summary = "api.admin.create.operation.summary")
//  @ApiResponses(value = {
//          @ApiResponse(responseCode = "200", description = "api.admin.create.api-responses.200.description"),
//          @ApiResponse(responseCode = "500", description = "api.cookbook.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
//  })
//  @DeleteMapping("deleteproduct")
//  public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto product) {
//    return ResponseEntity.ok(this.usersService.create(product));
//  }

  @Operation(summary = "api.admin.delete.operation.summary")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "api.admin.delete.api-responses.200.description"),
      @ApiResponse(responseCode = "404", description = "api.admin.delete.api-responses.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))}),
      @ApiResponse(responseCode = "500", description = "api.cookbook.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
  })
  @DeleteMapping("delete/{username}")
  public ResponseEntity<Void> deleteUser(@PathVariable @Size(min = 3, max = 50) String username) {
    this.usersService.delete(username);
    return ResponseEntity.ok().build();
  }
}
