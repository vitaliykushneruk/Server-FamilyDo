package com.kushneruk.vitaliy.serverfamilydo.model.users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class UserManagment {

    public static final String USER_WITH_THAT_NAME_ALREADY_EXISTS = "User with that name already exists!";
    public static final String INVALID_USERNAME = "Invalid username!";
    public static final String INVALID_PASSWORD = "Invalid password!";

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User register(String username, String password){

        log.info("register username {} password {}", username, password);

        registerValidation(username, password);

        String encryptedPassword = passwordEncoder.encode(password);

        User user = getBuildUser(username, encryptedPassword);
        log.info("user save {}", user);

        return userRepository.save(user);
    }

    private void registerValidation(String username, String password) {

        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException(INVALID_USERNAME);
        }

        if (!StringUtils.hasText(password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD);
        }

        userRepository.findByUsername(username).ifPresent(user -> {
            log.error(USER_WITH_THAT_NAME_ALREADY_EXISTS + " {}", user);
            throw new IllegalArgumentException(USER_WITH_THAT_NAME_ALREADY_EXISTS);
        });
    }

    private User getBuildUser(String username, String password) {

        return User.builder().userName(username).password(password).build();
    }
}
