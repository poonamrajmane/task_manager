package com.domain.taskManager.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.domain.taskManager.model.Task.Status;

public class TaskRequestDTO {
	
	@NotBlank(message = "Task title must not be empty")
	private String title;
	private String description;
	
	 @Enumerated(EnumType.STRING)
	    private Status status;
	    
	  

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    

}
