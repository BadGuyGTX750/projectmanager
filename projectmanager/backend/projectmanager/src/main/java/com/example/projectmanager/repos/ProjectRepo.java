package com.example.projectmanager.repos;

import com.example.projectmanager.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    Optional<Project> findProjectById(Long id);
}
