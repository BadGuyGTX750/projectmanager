package com.example.projectmanager.services;

import com.example.projectmanager.entities.Project;
import com.example.projectmanager.entities.Sprint;
import com.example.projectmanager.exceptions.ProjectNotFoundException;
import com.example.projectmanager.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    private final SprintService sprintService;
    @Autowired
    public ProjectService(ProjectRepo projectRepo, SprintService sprintService) {
        this.projectRepo = projectRepo;
        this.sprintService = sprintService;
    }
    public Project addProject(Project project){
        return projectRepo.save(project);
    }
    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }
    public Project getProjectById(Long id){
        return projectRepo.findProjectById(id).orElseThrow(() -> new ProjectNotFoundException("Project by id " + id + " was not found"));
    }
    public Project updateProject(Project project){
        return projectRepo.save(project);
    }
    public Project addSprintToProject(Long projectId, Long sprintId){
        Project project = getProjectById(projectId);
        Sprint sprint = sprintService.getSprintById(sprintId);
        project.addToSprintList(sprint);
        sprint.setProject(project);
        return projectRepo.save(project);
    }
    public Project removeSprintFromProject(Long projectId, Long sprintId){
        Project project = getProjectById(projectId);
        Sprint sprint = sprintService.getSprintById(sprintId);
        project.removeFromSprintList(sprint);
        sprint.setProject(null);
        return projectRepo.save(project);
    }
    public void deleteProject(Long id){
        projectRepo.deleteById(id);
    }
}
