package com.znyar.todoapp.controllers;

import com.znyar.todoapp.models.Task;
import com.znyar.todoapp.models.enums.TaskStatus;
import com.znyar.todoapp.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskService.taskList());
        return "tasks";
    }

    @PostMapping("/task/create")
    public String createTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }

    @PostMapping("/task/edit/{id}")
    public String updateTask(@PathVariable("id") long id, Task task) {
        taskService.updateTask(id, task);
        return "redirect:/";
    }

    @GetMapping("/task/{id}")
    public String getTaskById(@PathVariable("id") long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-info";
    }

    @RequestMapping("/task/delete/{id}")
    public String deleteTaskById(@PathVariable("id") long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/task/edit/status/{id}")
    public String updateStatus(@PathVariable("id") long id) {
        taskService.updateStatus(id);
        return "redirect:/";
    }

}
