package com.kushneruk.vitaliy.serverfamilydo.service;

import com.kushneruk.vitaliy.serverfamilydo.model.users.User;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.UserDto;

public interface UserService {
    User registerNewUser(final UserDto userDto);
}
