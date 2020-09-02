package com.pramati.banking.controller;

import com.pramati.banking.constants.SwaggerConstants;
import com.pramati.banking.dto.ResponseDto;
import com.pramati.banking.dto.UserDto;
import com.pramati.banking.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController extends ApiController {

  private final UserServiceImpl userService;


  /**
   * Api method to create user.
   * @param userDto userDto
   * @return UserDto userDto.
   */
  @PostMapping("/users")
  @ApiResponses(value = {
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_200, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_200),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_401, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_401),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_403, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_403),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_404, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_404) })
  @ApiOperation("Api method to create User")
  public ResponseEntity<ResponseDto<UserDto>> createUser(@RequestBody UserDto userDto) {

    return response("User Created Successfully", HttpStatus.OK,userService.createUser(userDto));

  }

  /**
   * Api method to update user.
   * @param userId userId.
   * @param userDto userDto.
   * @return UserDto userDto.
   */
  @PutMapping("/users/{userId}")
  @ApiResponses(value = {
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_200, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_200),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_401, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_401),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_403, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_403),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_404, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_404) })
  @ApiOperation("Api method to update User")
  public ResponseEntity<ResponseDto<UserDto>> updateUser(@PathVariable("userId") int userId,
                                                         @RequestBody UserDto userDto) {

    return response("User updated Successfully", HttpStatus.OK,userService.createUser(userDto));

  }

  /**
   * Api method to fetch user details based on id.
   * @param userId userId
   * @return UserDto userDto.
   */
  @GetMapping("/users/{userId}")
  @ApiResponses(value = {
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_200, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_200),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_401, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_401),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_403, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_403),
      @ApiResponse(code = SwaggerConstants.SWAGGER_RESPONSE_CODE_404, message = SwaggerConstants.SWAGGER_RESPONSE_MESSAGE_404) })
  @ApiOperation("Api method to retrieve User")
  public ResponseEntity<ResponseDto<UserDto>> getUser(@PathVariable("userId") int userId) {

    return response("User retrieved successfully", HttpStatus.OK, userService.getUser(userId));
  }


}
