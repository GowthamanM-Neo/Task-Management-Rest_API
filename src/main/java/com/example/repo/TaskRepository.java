package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.TaskModel;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, String>{

	List<TaskModel> findAllByTaskHolderName(String name);

}
