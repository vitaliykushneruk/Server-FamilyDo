package com.kushneruk.vitaliy.serverfamilydo.service;

import com.kushneruk.vitaliy.serverfamilydo.persistence.dao.UserRepository;
import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.UserDto;
import com.kushneruk.vitaliy.serverfamilydo.web.error.UserAlreadyExistException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.kushneruk.vitaliy.serverfamilydo.service.UserServiceImpl.ERROR_EXISTS_USER_NAME;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    public static final String ENCODE = "ENCODE";
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private UserDto userDto;

    @Before
    public void setUp() {
        userDto = UserDto
                .builder()
                .userName("userName")
                .password("password")
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .build();
    }

    @Test
    public void registerNewUserWithExistsUser() {
        UserDto newUser = UserDto.builder().build();
        when(userRepository.findUserByUserName(newUser.getUserName())).thenReturn(User.builder().build());
        thrown.expect(UserAlreadyExistException.class);
        thrown.expectMessage(ERROR_EXISTS_USER_NAME);
        userService.registerNewUser(newUser);
    }

    @Test
    public void registerNewUser(){
        when(passwordEncoder.encode(any())).thenReturn(ENCODE);
        when(userRepository.save(any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        User user = userService.registerNewUser(userDto);
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getLastName(), userDto.getLastName());
        assertEquals(user.getPassword(), ENCODE);
        assertEquals(user.getUserName(), userDto.getUserName());
    }
}