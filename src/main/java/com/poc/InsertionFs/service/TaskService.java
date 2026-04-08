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
}
