package com.poc.InsertionFs.controller;


import com.poc.InsertionFs.model.Task;
import com.poc.InsertionFs.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")

@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    public Task createTask(@RequestBody Task task) {

        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {

        return service.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {

        service.deleteTask(id);
    }
}
