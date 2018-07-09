package com.kushneruk.vitaliy.serverfamilydo.persistence.dao;

import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TaskListRepositoryTest extends TestContextConfiguration {

    @Autowired
    TaskListRepository taskListRepository;

    @Test
    public void contextLoads() {
        taskListRepository.findAll();
    }
}
