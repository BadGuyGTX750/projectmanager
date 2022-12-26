package com.example.projectmanager.controllers;

import com.example.projectmanager.entities.Subtask;
import com.example.projectmanager.services.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtask")
public class SubtaskController {
    private final SubtaskService subtaskService;

    @Autowired
    public SubtaskController(SubtaskService subtaskService) {
        this.subtaskService = subtaskService;
    }
    @PostMapping("/add")
    public ResponseEntity<Subtask> addSubtask(@RequestBody Subtask subtask){
        Subtask newSubtask = subtaskService.addSubtask(subtask);
        return new ResponseEntity<Subtask>(newSubtask, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Subtask>> getAllSubtasks(){
        List<Subtask> Subtasks = subtaskService.getAllSubtasks();
        return new ResponseEntity<List<Subtask>>(Subtasks, HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Subtask> getSubtaskById(@RequestParam("id") Long id){
        Subtask Subtask = subtaskService.getSubtaskById(id);
        return new ResponseEntity<Subtask>(Subtask, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Subtask> updateSubtask(@RequestBody Subtask Subtask){
        Subtask newSubtask = subtaskService.updateSubtask(Subtask);
        return new ResponseEntity<Subtask>(newSubtask, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSubtask(@RequestParam("id") Long id){
        subtaskService.deleteSubtask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
