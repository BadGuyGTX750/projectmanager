package com.example.projectmanager.services;

import com.example.projectmanager.entities.Subtask;
import com.example.projectmanager.exceptions.SubtaskNotFoundException;
import com.example.projectmanager.repos.SubtaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtaskService {
    private final SubtaskRepo subtaskRepo;

    @Autowired
    public SubtaskService(SubtaskRepo SubtaskRepo) {
        this.subtaskRepo = SubtaskRepo;
    }

    public Subtask addSubtask(Subtask subtask){
        return subtaskRepo.save(subtask);
    }
    public List<Subtask> getAllSubtasks(){
        return subtaskRepo.findAll();
    }
    public Subtask getSubtaskById(Long id){
        return subtaskRepo.findSubtaskById(id).orElseThrow(() -> new SubtaskNotFoundException("Subtask by id " + id + " was not found"));
    }
    public Subtask updateSubtask(Subtask Subtask){
        return subtaskRepo.save(Subtask);
    }
    public void deleteSubtask(Long id){
        subtaskRepo.deleteById(id);
    }
}
