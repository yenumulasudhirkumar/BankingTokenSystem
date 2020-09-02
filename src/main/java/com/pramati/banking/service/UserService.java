package com.pramati.banking.service;


import com.pramati.banking.dto.UserDto;

public interface UserService {


  /**
   * Service method to implement create new User.
   * @param userDto userDto.
   * @return UserDto
   */
  UserDto createUser(UserDto userDto);

  /**
   * Service method to implement update User details.
   * @param userDto userDto.
   * @return UserDto
   */
  UserDto updateUser(UserDto userDto);

  /**
   * Service method to retrieve User details.
   * @param userId userId.
   * @return UserDto
   */
  UserDto getUser(int userId);

}
