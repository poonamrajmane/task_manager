package com.domain.taskManager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.taskManager.dto.TaskRequestDTO;
import com.domain.taskManager.model.Task;
import com.domain.taskManager.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	 @Autowired
	    private TaskService taskService;

	    // Create or Update task
	    @PostMapping
	    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequestDTO task) {
	        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
	    }

	    // Get all tasks
	    @GetMapping
	    public ResponseEntity<List<Task>> getAllTasks() {
	        return ResponseEntity.ok(taskService.getAllTasks());
	        
	        
	    }
	    // Get task by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
	        Optional<Task> task = taskService.getTaskById(id);
	        //task.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
	        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // Delete task
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	        taskService.deleteTask(id);
	        return ResponseEntity.noContent().build();
	    }
	    

}
