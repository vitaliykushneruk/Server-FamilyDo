package com.kushneruk.vitaliy.serverfamilydo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TaskListRepository extends CrudRepository<TaskList, Integer> {

}
