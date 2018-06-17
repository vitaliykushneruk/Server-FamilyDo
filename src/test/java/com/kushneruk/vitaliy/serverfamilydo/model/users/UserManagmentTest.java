package com.kushneruk.vitaliy.serverfamilydo.model.users;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static com.kushneruk.vitaliy.serverfamilydo.model.users.UserManagment.INVALID_PASSWORD;
import static com.kushneruk.vitaliy.serverfamilydo.model.users.UserManagment.INVALID_USERNAME;
import static com.kushneruk.vitaliy.serverfamilydo.model.users.UserManagment.USER_WITH_THAT_NAME_ALREADY_EXISTS;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserManagmentTest {

    @InjectMocks
    UserManagment userManagment;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    UserRepository userRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    static final String ENCODE = "ENCODE";
    static final String USERNAME = "USERNAME";
    static final String PASSWORD = "PASSWORD";

    User user;

    @Before
    public void init(){

        user = getBuildUser();
    }

    @Test
    public void register(){

        when(passwordEncoder.encode(any())).thenReturn(ENCODE);
        when(userRepository.save(any())).thenReturn(user);

        assertEquals(user, userManagment.register(USERNAME, PASSWORD));
    }

    @Test
    public void registerError(){

        when(userRepository.findByUsername(any())).thenReturn(Optional.ofNullable(user));

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(USER_WITH_THAT_NAME_ALREADY_EXISTS);

        userManagment.register(USERNAME, PASSWORD);
    }

    @Test
    public void registerNullUserName(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(INVALID_USERNAME);

        userManagment.register(null, PASSWORD);
    }

    @Test
    public void registerNullPassword(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(INVALID_PASSWORD);

        userManagment.register(USERNAME, null);
    }

    @Test
    public void registerEmptyUserName(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(INVALID_USERNAME);

        userManagment.register("  ", PASSWORD);
    }

    @Test
    public void registerEmptyPassword(){

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(INVALID_PASSWORD);

        userManagment.register(USERNAME, "  ");
    }

    private User getBuildUser() {

        return User.builder().userName(USERNAME).password(ENCODE).build();
    }
}
