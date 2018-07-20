package com.kushneruk.vitaliy.serverfamilydo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@PasswordMatches
@Builder
public class UserDto {

    @NotNull
//    @Size(min = 1,message = "{userDto.firstName.Size}")
    private String firstName;

    @NotNull
//    @Size(min = 1,message = "{userDto.firstName.Size}")
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String userName;

    @NotNull
    private String password;
    @NotNull
    private String matchingPassword;
}