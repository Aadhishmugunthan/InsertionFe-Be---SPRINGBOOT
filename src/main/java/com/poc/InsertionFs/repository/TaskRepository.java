package com.poc.InsertionFs.repository;

import com.poc.InsertionFs.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
