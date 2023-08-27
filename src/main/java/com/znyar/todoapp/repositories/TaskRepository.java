package com.znyar.todoapp.repositories;

import com.znyar.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
