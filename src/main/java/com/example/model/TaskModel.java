package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskModel {

	@Id
	private String taskId;
	private String taskHolderName;
	private String taskDate;
	private String taskName;
	private String taskStatus;
	
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskHolderName() {
		return taskHolderName;
	}
	public void setTaskHolderName(String taskHolderName) {
		this.taskHolderName = taskHolderName;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	@Override
	public String toString() {
		return "TaskModel [taskId=" + taskId + ", taskHolderName=" + taskHolderName + ", taskDate=" + taskDate
				+ ", taskName=" + taskName + ", taskStatus=" + taskStatus + "]";
	}
}
