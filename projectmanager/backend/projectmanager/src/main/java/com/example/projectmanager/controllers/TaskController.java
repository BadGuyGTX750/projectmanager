package com.example.projectmanager.controllers;

import com.example.projectmanager.entities.Task;
import com.example.projectmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService TaskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.TaskService = taskService;
    }
    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task newTask = TaskService.addTask(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = TaskService.getAllTasks();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Task> getTaskById(@RequestParam("id") Long id){
        Task task = TaskService.getTaskById(id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task newTask = TaskService.updateTask(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.OK);
    }
    @PutMapping("/addSubtask")
    public ResponseEntity<Task> addSubtaskToTask(@RequestParam("taskId") Long taskId,
                                              @RequestParam("subtaskId") Long subtaskId){
        Task Task = TaskService.addSubtaskToTask(taskId, subtaskId);
        return new ResponseEntity<Task>(Task, HttpStatus.OK);
    }
    @PutMapping("/removeSubtask")
    public ResponseEntity<Task> removeSubtaskFromTask(@RequestParam("taskId") Long taskId,
                                                       @RequestParam("subtaskId") Long subtaskId){
        Task Task = TaskService.removeSubtaskFromTask(taskId, subtaskId);
        return new ResponseEntity<Task>(Task, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTask(@RequestParam("id") Long id){
        TaskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
