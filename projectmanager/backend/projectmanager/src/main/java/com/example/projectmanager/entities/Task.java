package com.example.projectmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String taskName;
    private String description;
    private TaskStatus taskStatus;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private List<Subtask> subtaskList = new ArrayList<>();
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Task() {
    }
    public Task(String taskName, String description, TaskStatus taskStatus, LocalDate startDate, LocalDate endDate, List<Subtask> subtaskList, Sprint sprint, Employee employee) {
        this.taskName = taskName;
        this.description = description;
        this.taskStatus = taskStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subtaskList = subtaskList;
        this.sprint = sprint;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
