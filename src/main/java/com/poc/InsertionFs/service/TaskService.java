package com.poc.InsertionFs.service;


import com.poc.InsertionFs.model.Task;
import com.poc.InsertionFs.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public Task createTask(Task task) {

        task.setCompleted(false);
        task.setCreatedAt(LocalDateTime.now());

        return repository.save(task);
    }

    public List<Task> getAllTasks() {

        return repository.findAll();
    }

    public void deleteTask(Long id) {

        repository.deleteById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.getCompleted());

        return repository.save(task);
    }
    public Task toggleTask(Long id) {

        Task task = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        // TOGGLE BOOLEAN
        task.setCompleted(!task.getCompleted());

        return repository.save(task);
    }
}
