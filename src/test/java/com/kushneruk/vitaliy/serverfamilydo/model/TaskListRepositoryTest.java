package com.kushneruk.vitaliy.serverfamilydo.model;

import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class  TaskListRepositoryTest extends TestContextConfiguration {

	@Autowired
	TaskListRepository taskListRepository;

	@Test
	public void contextLoads() {
		taskListRepository.findAll();
	}
}
