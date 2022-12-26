package com.example.projectmanager.services;

import com.example.projectmanager.entities.Sprint;
import com.example.projectmanager.entities.Subtask;
import com.example.projectmanager.entities.Task;
import com.example.projectmanager.exceptions.TaskNotFoundException;
import com.example.projectmanager.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    private final SubtaskService subtaskService;

    @Autowired
    public TaskService(TaskRepo taskRepo, SubtaskService subtaskService) {
        this.taskRepo = taskRepo;
        this.subtaskService = subtaskService;
    }

    public Task addTask(Task task){
        return taskRepo.save(task);
    }
    public List<Task> getAllTasks(){
        return taskRepo.findAll();
    }
    public Task getTaskById(Long id){
        return taskRepo.findTaskById(id).orElseThrow(() -> new TaskNotFoundException("task by id " + id + " was not found"));
    }
    public Task updateTask(Task task){
        return taskRepo.save(task);
    }
    public Task addSubtaskToTask(Long taskId, Long subtaskId){
        Task task = getTaskById(taskId);
        Subtask subtask = subtaskService.getSubtaskById(subtaskId);
        task.addToSubtaskList(subtask);
        subtask.setTask(task);
        return taskRepo.save(task);
    }
    public Task removeSubtaskFromTask(Long taskId, Long subtaskId){
        Task task = getTaskById(taskId);
        Subtask subtask = subtaskService.getSubtaskById(subtaskId);
        task.removeFromSubtaskList(subtask);
        subtask.setTask(null);
        return taskRepo.save(task);
    }
    public void deleteTask(Long id){
        taskRepo.deleteById(id);
    }
}
