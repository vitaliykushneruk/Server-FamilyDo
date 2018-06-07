package com.kushneruk.vitaliy.serverfamilydo.model.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class UserManagment {

    @Autowired
    UserRepository userRepository;

    //private final PasswordEncoder passwordEncoder;

    public User register(String username, String password){
        Assert.notNull(username, "Username must not be null!");
        Assert.notNull(password, "Password must not be null!");

        userRepository.findByUsername(username).ifPresent(user -> {
            throw new IllegalArgumentException("User with that name already exists!");
        });
        String encryptedPassword = password;//passwordEncoder.encode(password);
        return null;
        //return userRepository.save( new User(username, encryptedPassword));
    }
}
