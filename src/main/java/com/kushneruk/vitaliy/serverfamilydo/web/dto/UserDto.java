package com.kushneruk.vitaliy.serverfamilydo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@PasswordMatches
@Builder
public class UserDto {

    @NotNull
    @Size(min = 1, max = 255, message = "{userDto.firstName.Size}")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 255, message = "{userDto.lastName.Size}")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 255, message = "{userDto.email.Size}")
    private String email;

    @NotNull
    @Size(min = 1, max = 255, message = "{userDto.userName.Size}")
    private String userName;

    @NotNull
    @Size(min = 1, max = 255, message = "{userDto.password.Size}")
    private String password;

    @NotNull
    @Size(min = 1, max = 255, message = "{userDto.matchingPassword.Size}")
    private String matchingPassword;
}