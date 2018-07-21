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
import static com.kushneruk.vitaliy.serverfamilydo.web.utils.WebUtils.getRandomString;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@AutoConfigureMockMvc
public class RegisterControllerTest extends TestContextConfiguration {

    private static final String MESSAGE_LEN_MIN_VALID = getRandomString(1);
    private static final String MESSAGE_LEN_MAX_VALID = getRandomString(255);
    private static final String MESSAGE_LEN_MIN_NO_VALID = getRandomString(0);
    private static final String MESSAGE_LEN_MAX_NO_VALID = getRandomString(256);
    private static final String URI_USER_REGISTRATION = "/user/registration";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrationUserWithAllValidMinValue() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithOk(json);
    }

    @Test
    public void registrationUserWithAllValidMaxValue() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MAX_VALID)
                .firstName(MESSAGE_LEN_MAX_VALID)
                .lastName(MESSAGE_LEN_MAX_VALID)
                .password(MESSAGE_LEN_MAX_VALID)
                .userName(MESSAGE_LEN_MAX_VALID)
                .matchingPassword(MESSAGE_LEN_MAX_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithOk(json);
    }

    @Test
    public void registrationUserWithNullEmail() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(null)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "{\"field\":\"email\",\"defaultMessage\":\"must not be null\"}");
    }

    @Test
    public void registrationUserWithNullFirstName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(null)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "{\"field\":\"firstName\",\"defaultMessage\":\"must not be null\"}");
    }

    @Test
    public void registrationUserWithNullLastName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(null)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "{\"field\":\"lastName\",\"defaultMessage\":\"must not be null\"}");
    }

    @Test
    public void registrationUserWithNullPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(null)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "{\"field\":\"password\",\"defaultMessage\":\"must not be null\"}");
    }

    @Test
    public void registrationUserWithNullUserName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(null)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "{\"field\":\"userName\",\"defaultMessage\":\"must not be null\"}");
    }

    @Test
    public void registrationUserWithNullMatchingPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(null)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "{\"field\":\"matchingPassword\",\"defaultMessage\":\"must not be null\"}");
    }

    @Test
    public void registrationUserWithMinNoValidMEmail() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_NO_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"email\",\"defaultMessage\":\"{userDto.email.Size}\"}]");
    }

    @Test
    public void registrationUserWithMinNoValidMFirstName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_NO_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"firstName\",\"defaultMessage\":\"{userDto.firstName.Size}\"}]");
    }

    @Test
    public void registrationUserWithMinNoValidMLastName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_NO_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"lastName\",\"defaultMessage\":\"{userDto.lastName.Size}\"}]");
    }

    @Test
    public void registrationUserWithMinNoValidMPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_NO_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"password\",\"defaultMessage\":\"{userDto.password.Size}\"}]");
    }

    @Test
    public void registrationUserWithMinNoValidMUserName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_NO_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"userName\",\"defaultMessage\":\"{userDto.userName.Size}\"}]");
    }

    @Test
    public void registrationUserWithMinNoValidMatchingPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_NO_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"matchingPassword\",\"defaultMessage\":\"{userDto.matchingPassword.Size}\"}]");
    }

    @Test
    public void registrationUserWithMaxNoValidMEmail() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MAX_NO_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"email\",\"defaultMessage\":\"{userDto.email.Size}\"}]");
    }

    @Test
    public void registrationUserWithMaxNoValidMFirstName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MAX_NO_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"firstName\",\"defaultMessage\":\"{userDto.firstName.Size}\"}]");
    }

    @Test
    public void registrationUserWithMaxNoValidMLastName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MAX_NO_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"lastName\",\"defaultMessage\":\"{userDto.lastName.Size}\"}]");
    }

    @Test
    public void registrationUserWithMaxNoValidMPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MAX_NO_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"password\",\"defaultMessage\":\"{userDto.password.Size}\"}]");
    }

    @Test
    public void registrationUserWithMaxNoValidMUserName() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MAX_NO_VALID)
                .matchingPassword(MESSAGE_LEN_MIN_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"userName\",\"defaultMessage\":\"{userDto.userName.Size}\"}]");
    }

    @Test
    public void registrationUserWithMaxNoValidMatchingPassword() throws Exception {
        UserDto userDto = UserDto.builder()
                .email(MESSAGE_LEN_MIN_VALID)
                .firstName(MESSAGE_LEN_MIN_VALID)
                .lastName(MESSAGE_LEN_MIN_VALID)
                .password(MESSAGE_LEN_MIN_VALID)
                .userName(MESSAGE_LEN_MIN_VALID)
                .matchingPassword(MESSAGE_LEN_MAX_NO_VALID)
                .build();
        String json = getJsonFromObject(userDto);

        registrationUserWithNullError(json, "[{\"field\":\"matchingPassword\",\"defaultMessage\":\"{userDto.matchingPassword.Size}\"}]");
    }

    private void registrationUserWithNullError(String json, String error) throws Exception {
        ResultActions resultActions = mockMvc.perform(post(URI_USER_REGISTRATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(400));
        resultActions.andExpect(jsonPath("$.error", Matchers.is("InvaliduserDto")));
        resultActions.andExpect(jsonPath("$.message", containsString(error)));
    }

    private void registrationUserWithOk(String json) throws Exception {
        ResultActions resultActions = mockMvc.perform(post(URI_USER_REGISTRATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));
        resultActions.andExpect(status().is(200));
        resultActions.andExpect(jsonPath("$.success", is(true)));
    }
}