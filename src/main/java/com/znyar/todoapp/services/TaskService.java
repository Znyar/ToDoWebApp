package com.znyar.todoapp.services;

import com.znyar.todoapp.models.Task;
import com.znyar.todoapp.models.enums.TaskStatus;
import com.znyar.todoapp.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> taskList() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(long id, Task taskToBeUpdated) {
        Task updatedTask = taskRepository.findById(id).orElse(null);
        if (updatedTask != null) {
            updatedTask.setTitle(taskToBeUpdated.getTitle());
            updatedTask.setDescription(taskToBeUpdated.getDescription());
            taskRepository.save(updatedTask);
        }
    }

    public void updateStatus(long id) {
        Task updatedTask = taskRepository.findById(id).orElse(null);
        if (updatedTask != null ) {
            switch (updatedTask.getStatus()) {
                case ACTIVE -> updatedTask.setStatus(TaskStatus.FINISHED);
                case FINISHED -> updatedTask.setStatus(TaskStatus.INACTIVE);
                case INACTIVE -> updatedTask.setStatus(TaskStatus.ACTIVE);
            }
            taskRepository.save(updatedTask);
        }
    }

}
