package com.pramati.banking.service.impl;

import com.pramati.banking.converter.UserConverter;
import com.pramati.banking.dto.UserDto;
import com.pramati.banking.entity.Customer;
import com.pramati.banking.entity.User;
import com.pramati.banking.exception.UserException;
import com.pramati.banking.repository.UserRepository;
import com.pramati.banking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements UserService {

  private final UserConverter userConverter;
  private final UserRepository userRepository;

  /**
   * Service method to implement create new User.
   *
   * @param userDto userDto.
   * @return UserDto
   */
  @Override
  public UserDto createUser(UserDto userDto) {
    return userConverter.buildDtoFromEntity(userRepository.save(userConverter.buildEntityFromDto(userDto)));
  }

  /**
   * Service method to implement update User details.
   *
   * @param userDto userDto.
   * @return UserDto
   */
  @Override
  public UserDto updateUser(UserDto userDto) {

    User user = updateUserDetails(userDto);
    Customer customer = user.getCustomer();
    customer.setServiceType(userDto.getCustomerDto().getServiceType());
    customer.setExistingCustomer(userDto.getCustomerDto().isExistingCustomer());
    customer.setDeleted(false);
    user.setCustomer(customer);
    return userConverter.buildDtoFromEntity(userRepository.save(user));
  }

  /**
   * Service method set all the User Details.
   * @param userDto userDto
   * @return User
   */
  public User updateUserDetails(UserDto userDto) {
    User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new UserException("Invalid user Id"));
    user.setAddress(userDto.getAddress());
    user.setBranchName(userDto.getBranchName());
    user.setEmail(userDto.getEmail());
    user.setName(userDto.getName());
    user.setPhone(userDto.getPhone());
    user.setGender(userDto.getGender());
    user.setDeleted(false);
    user.setId(userDto.getId());
    return user;
  }



  /**
   * Service method to retrieve User details.
   *
   * @param userId userId.
   * @return UserDto
   */
  @Override
  public UserDto getUser(int userId) {
    return userConverter.buildDtoFromEntity(userRepository.findById(userId).orElseThrow(() -> new UserException("Invalid user Id")));
  }

  



}
