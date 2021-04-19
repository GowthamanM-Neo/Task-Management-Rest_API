package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TaskModel;
import com.example.repo.TaskRepository;

@RestController
public class Controller {

	@Autowired
	TaskRepository TaskRepo;
	
	///save a new task
	@PostMapping("/saveTask")
	public void savetask(@RequestBody TaskModel task) {
		TaskRepo.save(task);
	}
	
	//get all tasks
	@GetMapping("/allTasks")
	public List<TaskModel> getAllTasks(){
		return (List<TaskModel>) TaskRepo.findAll();
	}
	
	//get tasks by holder name
	@GetMapping("/getTask")
	public List<TaskModel> getByHolderName(@RequestParam(name="name") String name){
		return TaskRepo.findAllByTaskHolderName(name);
	}
	
	
	//change the status of the task
	@GetMapping("/changeStatus")
	public void changeStatus(@RequestBody Map<String,Object> data,@RequestParam(name="id") String id) {
		 var a = TaskRepo.findById(id);
		 a.get().setTaskStatus(data.get("status").toString());
		 TaskRepo.save(a.get());
	}
	
	@GetMapping("/deleteTask")
	public void deleteTask(@RequestParam(name="id") String id) {
		TaskRepo.deleteById(id);
	}
}
