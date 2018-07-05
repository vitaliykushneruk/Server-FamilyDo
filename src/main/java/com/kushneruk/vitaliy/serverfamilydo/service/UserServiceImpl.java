package com.kushneruk.vitaliy.serverfamilydo.service;

import com.kushneruk.vitaliy.serverfamilydo.model.users.User;
import com.kushneruk.vitaliy.serverfamilydo.model.users.UserRepository;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.UserDto;
import com.kushneruk.vitaliy.serverfamilydo.web.error.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public static final String ERROR_EXISTS_USER_NAME = "User with this UserName exists {}";

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(final UserDto userDto) {
        log.debug("userDto: {}", userDto);
        if (userNameExists(userDto.getUserName())) {
            final String message = ERROR_EXISTS_USER_NAME + userDto.getUserName();
            log.error(message);
            throw new UserAlreadyExistException(message);
        }

        User newUser = User.builder()
                .userName(userDto.getUserName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();

        log.debug("newUser: {}", newUser);

        return userRepository.save(newUser);
    }

    private boolean userNameExists(final String userName) {
        return userRepository.findByUsername(userName).isPresent();
    }
}
