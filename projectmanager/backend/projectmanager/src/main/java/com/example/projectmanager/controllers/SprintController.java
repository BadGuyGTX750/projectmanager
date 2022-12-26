package com.example.projectmanager.controllers;

import com.example.projectmanager.entities.Sprint;
import com.example.projectmanager.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprint")
public class SprintController {
    private final SprintService sprintService;

    @Autowired
    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }
    @PostMapping("/add")
    public ResponseEntity<Sprint> addSprint(@RequestBody Sprint sprint){
        Sprint newSprint = sprintService.addSprint(sprint);
        return new ResponseEntity<Sprint>(newSprint, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Sprint>> getAllSprints(){
        List<Sprint> sprints = sprintService.getAllSprints();
        return new ResponseEntity<List<Sprint>>(sprints, HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Sprint> getSprintById(@RequestParam("id") Long id){
        Sprint sprint = sprintService.getSprintById(id);
        return new ResponseEntity<Sprint>(sprint, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Sprint> updateSprint(@RequestBody Sprint sprint){
        Sprint newsprint = sprintService.updateSprint(sprint);
        return new ResponseEntity<Sprint>(newsprint, HttpStatus.OK);
    }
    @PutMapping("/addTask")
    public ResponseEntity<Sprint> addTaskToSprint(@RequestParam("sprintId") Long sprintId,
                                                  @RequestParam("taskId") Long taskId){
        Sprint sprint = sprintService.addTaskToSprint(sprintId, taskId);
        return new ResponseEntity<Sprint>(sprint, HttpStatus.OK);
    }
    @PutMapping("/removeTask")
    public ResponseEntity<Sprint> removeTaskFromSprint(@RequestParam("sprintId") Long sprintId,
                                                       @RequestParam("taskId") Long taskId){
        Sprint sprint = sprintService.removeTaskFromSprint(sprintId, taskId);
        return new ResponseEntity<Sprint>(sprint, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSprint(@RequestParam("id") Long id){
        sprintService.deleteSprint(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
