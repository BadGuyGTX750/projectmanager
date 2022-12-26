package com.example.projectmanager.controllers;

import com.example.projectmanager.entities.Project;
import com.example.projectmanager.repos.ProjectRepo;
import com.example.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<Project>(newProject, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Project> getProjectById(@RequestParam("id") Long id){
        Project project = projectService.getProjectById(id);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Project> updateProject(@RequestBody Project project){
        Project newProject = projectService.updateProject(project);
        return new ResponseEntity<Project>(newProject, HttpStatus.OK);
    }
    @PutMapping("/addSprint")
    public ResponseEntity<Project> addSprintToProject(@RequestParam("projectId") Long projectId,
                                                      @RequestParam("projectId") Long sprintId){
        Project project = projectService.addSprintToProject(projectId, sprintId);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
    @PutMapping("/removeSprint")
    public ResponseEntity<Project> removeSprintFromProject(@RequestParam("projectId") Long projectId,
                                                           @RequestParam("projectId") Long sprintId){
        Project project = projectService.removeSprintFromProject(projectId, sprintId);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProject(@RequestParam("id") Long id){
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
