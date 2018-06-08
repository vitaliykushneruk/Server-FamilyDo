package com.kushneruk.vitaliy.serverfamilydo.web;

import com.kushneruk.vitaliy.serverfamilydo.model.users.User;
import com.kushneruk.vitaliy.serverfamilydo.model.users.UserManagment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserManagment userManagment;

    @GetMapping("getAll")
    public List<User> users() {
        userManagment.register("test1", "test2");
        final List<User> all = userManagment.findAll();
        return all;
    }
}
