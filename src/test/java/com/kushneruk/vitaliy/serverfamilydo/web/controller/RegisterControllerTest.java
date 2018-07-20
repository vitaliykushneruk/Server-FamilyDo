package com.kushneruk.vitaliy.serverfamilydo.web.controller;

import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.UserDto;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static com.kushneruk.vitaliy.serverfamilydo.web.utils.WebUtils.getJsonFromObject;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@Transactional
public class RegisterControllerTest extends TestContextConfiguration {
    public static final String STR = "str";

    @Autowired
    RegisterController registerController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void registrationUserWithNullEmail() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(null)
                .firstName(STR)
                .lastName(STR)
                .password(STR)
                .userName(STR)
                .matchingPassword(STR)
                .build();
        String json = getJsonFromObject(userDto);

        ResultActions resultActions = mockMvc.perform(post("/user/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(400));
        String error = "{\"field\":\"email\",\"defaultMessage\":\"must not be null\"}";
        resultActions.andExpect(jsonPath("$.error", Matchers.is("InvaliduserDto")))
                .andExpect(jsonPath("$.message", containsString(error)));
    }

    @Test
    public void registrationUserWithNullFirstName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(STR)
                .firstName(null)
                .lastName(STR)
                .password(STR)
                .userName(STR)
                .matchingPassword(STR)
                .build();
        String json = getJsonFromObject(userDto);

        ResultActions resultActions = mockMvc.perform(post("/user/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(400));
        String error = "{\"field\":\"firstName\",\"defaultMessage\":\"must not be null\"}";
        resultActions.andExpect(jsonPath("$.error", Matchers.is("InvaliduserDto")))
                .andExpect(jsonPath("$.message", containsString(error)));
    }

    @Test
    public void registrationUserWithNullLastName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(STR)
                .firstName(STR)
                .lastName(null)
                .password(STR)
                .userName(STR)
                .matchingPassword(STR)
                .build();
        String json = getJsonFromObject(userDto);

        ResultActions resultActions = mockMvc.perform(post("/user/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(400));
        String error = "{\"field\":\"lastName\",\"defaultMessage\":\"must not be null\"}";
        resultActions.andExpect(jsonPath("$.error", Matchers.is("InvaliduserDto")))
                .andExpect(jsonPath("$.message", containsString(error)));
    }

    @Test
    public void registrationUserWithNullPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(STR)
                .firstName(STR)
                .lastName(STR)
                .password(null)
                .userName(STR)
                .matchingPassword(STR)
                .build();
        String json = getJsonFromObject(userDto);

        ResultActions resultActions = mockMvc.perform(post("/user/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(400));
        String error = "{\"field\":\"password\",\"defaultMessage\":\"must not be null\"}";
        resultActions.andExpect(jsonPath("$.error", Matchers.is("InvaliduserDto")))
                .andExpect(jsonPath("$.message", containsString(error)));
    }

    @Test
    public void registrationUserWithNullUserName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(STR)
                .firstName(STR)
                .lastName(STR)
                .password(STR)
                .userName(null)
                .matchingPassword(STR)
                .build();
        String json = getJsonFromObject(userDto);

        ResultActions resultActions = mockMvc.perform(post("/user/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(400));
        String error = "{\"field\":\"userName\",\"defaultMessage\":\"must not be null\"}";
        resultActions.andExpect(jsonPath("$.error", Matchers.is("InvaliduserDto")))
                .andExpect(jsonPath("$.message", containsString(error)));
    }

    @Test
    public void registrationUserWithNullMatchingPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(STR)
                .firstName(STR)
                .lastName(STR)
                .password(STR)
                .userName(STR)
                .matchingPassword(null)
                .build();
        String json = getJsonFromObject(userDto);

        ResultActions resultActions = mockMvc.perform(post("/user/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(400));
        String error = "{\"field\":\"matchingPassword\",\"defaultMessage\":\"must not be null\"}";
        resultActions.andExpect(jsonPath("$.error", Matchers.is("InvaliduserDto")))
                .andExpect(jsonPath("$.message", containsString(error)));
    }
}