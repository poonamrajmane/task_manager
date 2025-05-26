package com.domain.taskManager.repository;

import org.springframework.data.jpa.repository.*;

import com.domain.taskManager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
