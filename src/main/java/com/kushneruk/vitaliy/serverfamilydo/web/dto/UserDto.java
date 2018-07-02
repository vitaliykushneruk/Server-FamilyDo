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
    @Size(min = 1,message = "{userDto.firstName.Size}")
    private String firstName;

    @NotNull
    @Size(min = 1,message = "{userDto.firstName.Size}")
    private String lastName;

    private String email;

    private String userName;

    private String password;

    private String matchingPassword;
}
