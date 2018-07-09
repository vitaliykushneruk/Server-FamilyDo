package com.kushneruk.vitaliy.serverfamilydo.persistence.model;

import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import com.kushneruk.vitaliy.serverfamilydo.persistence.dao.TaskListRepository;
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
