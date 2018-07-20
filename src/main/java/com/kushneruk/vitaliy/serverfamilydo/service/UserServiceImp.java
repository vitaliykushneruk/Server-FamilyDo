package com.kushneruk.vitaliy.serverfamilydo.service;

import com.kushneruk.vitaliy.serverfamilydo.persistence.dao.UserRepository;
import com.kushneruk.vitaliy.serverfamilydo.persistence.dao.VerificationTokenRepository;
import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import com.kushneruk.vitaliy.serverfamilydo.persistence.model.VerificationToken;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.UserDto;
import com.kushneruk.vitaliy.serverfamilydo.web.error.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    public static final String ERROR_EXISTS_USER_NAME = "User with this UserName exists";

    @Autowired
    UserRepository userRepository;

    @Autowired
    VerificationTokenRepository tokenRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(final UserDto userDto) {
        log.debug("userDto: {}", userDto);
        if (userNameExists(userDto.getUserName())) {
            final String message = ERROR_EXISTS_USER_NAME + " " + userDto.getUserName();
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
        return Optional.ofNullable(userRepository.findUserByUserName(userName)).isPresent();
    }

    @Override
    public void createVerificationTokenForUser(User user, String token) {
        final VerificationToken verificationToken = VerificationToken.builder().token(token).user(user).build();
        tokenRepository.save(verificationToken);
    }
}
