package com.kushneruk.vitaliy.serverfamilydo.persistence.dao;

import com.kushneruk.vitaliy.serverfamilydo.persistence.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

}
