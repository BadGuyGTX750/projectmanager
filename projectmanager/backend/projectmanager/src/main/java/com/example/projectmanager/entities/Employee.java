package com.example.projectmanager.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String jobTitle;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Task> taskList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Subtask> subtaskList = new ArrayList<>();

    public Employee() {
    }
    public Employee(String name, String jobTitle, String email, List<Task> taskList, List<Subtask> subtaskList) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.taskList = taskList;
        this.subtaskList = subtaskList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addToTaskList(Task task){
        taskList.add(task);
    }

    public void removeFromTaskList(Task task){
        taskList.remove(task);
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Subtask> getSubtaskList() {
        return subtaskList;
    }

    public void setSubtaskList(List<Subtask> subtaskList) {
        this.subtaskList = subtaskList;
    }

    public void addToSubtaskList(Subtask subtask){
        subtaskList.add(subtask);
    }

    public void removeFromSubtaskList(Subtask subtask){
        subtaskList.remove(subtask);
    }
}
