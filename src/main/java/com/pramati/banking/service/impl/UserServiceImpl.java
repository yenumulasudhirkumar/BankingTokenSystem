package com.pramati.banking.service.impl;


import com.pramati.banking.converter.UserConverter;
import com.pramati.banking.dto.UserDto;
import com.pramati.banking.entity.User;
import com.pramati.banking.exception.UserException;
import com.pramati.banking.factory.UserTypeFactory;
import com.pramati.banking.repository.UserRepository;
import com.pramati.banking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


  private final UserTypeFactory userTypeFactory;
  private final UserRepository userRepository;
  private final UserConverter userConverter;


  /**
   * Service method to implement create new User.
   *
   * @param userDto userDto.
   * @return UserDto
   */
  @Override
  public UserDto createUser(UserDto userDto) {
    checkValidity(userDto);
    UserService userService = userTypeFactory.getUser(userDto.getUserRole());
    return userService.createUser(userDto);
  }

  /**
   * Service method to implement update User details.
   *
   * @param userDto userDto.
   * @return UserDto
   */
  @Override
  public UserDto updateUser(UserDto userDto) {

    checkValidity(userDto);
    UserService userService = userTypeFactory.getUser(userDto.getUserRole());
    return userService.updateUser(userDto);
  }

  /**
   * Service method to retrieve User details.
   *
   * @param userId userId.
   * @return UserDto
   */
  @Override
  public UserDto getUser(int userId) {
    return userConverter.buildDtoFromEntity(getUserById(userId));
  }


  public User getUserById(int userId) {
    return userRepository.findById(userId).orElseThrow(() -> new UserException("Invalid user Id"));
  }




  /**
   * Service method to validate user.
   * @param userDto userDto.
   */
  public void checkValidity(UserDto userDto) {

    if (userDto == null) {
      throw new UserException("Please provide valid user details");
    }

    if (userDto.getUserRole() == null) {
      throw new UserException("Please provide valid User role");
    }

    if (userDto.getEmail() == null) {
      throw new UserException("Please provide valid email Id");
    }

    if (userDto.getPhone() == null) {
      throw new UserException("Please provide valid phone no.");
    }

  }

}
