package com.kushneruk.vitaliy.serverfamilydo.web.controller;

import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import com.kushneruk.vitaliy.serverfamilydo.registration.OnRegistrationCompleteEvent;
import com.kushneruk.vitaliy.serverfamilydo.service.UserService;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.ResultDto;
import com.kushneruk.vitaliy.serverfamilydo.web.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("registration")
    ResponseEntity<ResultDto> registrationUser(@RequestBody @Valid final UserDto user, final HttpServletRequest request) {
        log.debug("Registration information {}", user);
        User registerNewUser = userService.registerNewUser(user);
        final ResultDto build = ResultDto.builder().success(true).build();
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registerNewUser, getAppUrl(request)));
        return ResponseEntity.ok(build);
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
