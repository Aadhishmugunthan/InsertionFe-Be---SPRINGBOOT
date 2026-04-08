package com.poc.InsertionFs.controller;


import com.poc.InsertionFs.model.Task;
import com.poc.InsertionFs.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        return service.updateTask(id, task);
    }
    @PutMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTask(@PathVariable Long id) {

        Task updatedTask = service.toggleTask(id);

        return ResponseEntity.ok(updatedTask);
    }
}
