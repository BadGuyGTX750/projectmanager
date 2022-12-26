package com.example.projectmanager.repos;

import com.example.projectmanager.entities.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubtaskRepo extends JpaRepository<Subtask, Long> {
    Optional<Subtask> findSubtaskById(Long id);
}
