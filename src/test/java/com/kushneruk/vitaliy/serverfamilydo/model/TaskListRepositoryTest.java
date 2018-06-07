package com.kushneruk.vitaliy.serverfamilydo.model;

import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class  TaskListRepositoryTest extends TestContextConfiguration {

	@Autowired
	TaskListRepository taskListRepository;

	@Test
	public void contextLoads() {
		taskListRepository.findAll();
	}
}
