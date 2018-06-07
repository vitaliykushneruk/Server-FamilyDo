package com.kushneruk.vitaliy.serverfamilydo.model.users;

import com.google.common.collect.Iterables;
import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserRepositoryTest extends TestContextConfiguration {
    @Autowired
    UserRepository userRepository;

    final String userName = "oper";
    final String password = "oper_pass";

    @Before
    public void init(){
        User user = User.builder().id(1).userName(userName).password(password).build();
        userRepository.save(user);
    }

    @Test
    public void findAll(){
        assertThat(1, equalTo(Iterables.size(userRepository.findAll())));
    }
}
