package com.example.projectmanager.repos;

import com.example.projectmanager.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SprintRepo extends JpaRepository<Sprint, Long> {
    Optional<Sprint> findSprintById(Long id);
}
