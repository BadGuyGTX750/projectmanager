package com.example.projectmanager.repos;

import com.example.projectmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Optional<Task> findTaskById(Long id);
}
