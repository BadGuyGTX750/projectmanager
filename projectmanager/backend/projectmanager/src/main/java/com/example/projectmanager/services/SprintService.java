package com.example.projectmanager.services;

import com.example.projectmanager.entities.Project;
import com.example.projectmanager.entities.Sprint;
import com.example.projectmanager.entities.Task;
import com.example.projectmanager.exceptions.SprintNotFoundException;
import com.example.projectmanager.repos.SprintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {
    private final SprintRepo sprintRepo;
    private final TaskService taskService;

    @Autowired
    public SprintService(SprintRepo sprintRepo, TaskService taskService) {
        this.sprintRepo = sprintRepo;
        this.taskService = taskService;
    }

    public Sprint addSprint(Sprint sprint){
        return sprintRepo.save(sprint);
    }
    public List<Sprint> getAllSprints(){
        return sprintRepo.findAll();
    }
    public Sprint getSprintById(Long id){
        return sprintRepo.findSprintById(id).orElseThrow(() -> new SprintNotFoundException("Sprint by id " + id + " was not found"));
    }
    public Sprint updateSprint(Sprint sprint){
        return sprintRepo.save(sprint);
    }
    public Sprint addTaskToSprint(Long sprintId, Long taskId){
        Sprint sprint = getSprintById(sprintId);
        Task task = taskService.getTaskById(taskId);
        sprint.addToTaskList(task);
        task.setSprint(sprint);
        return sprintRepo.save(sprint);
    }
    public Sprint removeTaskFromSprint(Long sprintId, Long taskId){
        Sprint sprint = getSprintById(sprintId);
        Task task = taskService.getTaskById(taskId);
        sprint.removeFromTaskList(task);
        task.setSprint(null);
        return sprintRepo.save(sprint);
    }
    public void deleteSprint(Long id){
        sprintRepo.deleteById(id);
    }
}
