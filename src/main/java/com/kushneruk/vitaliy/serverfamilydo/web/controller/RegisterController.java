package com.kushneruk.vitaliy.serverfamilydo.web.controller;

import com.kushneruk.vitaliy.serverfamilydo.service.UserService;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.ResultDto;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping("registration")
    ResponseEntity<ResultDto> registrationUser(@RequestBody @Valid final UserDto user) {
        log.debug("Registration information {}", user);
        userService.registerNewUser(user);
        final ResultDto build = ResultDto.builder().success(true).build();
        return ResponseEntity.ok(build);
    }
}
