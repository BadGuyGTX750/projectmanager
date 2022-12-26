package com.example.projectmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subtask")
public class Subtask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String subtaskName;
    private String description;
    private SubtaskStatus subtaskStatus;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Subtask() {
    }
    public Subtask(String subtaskName, String description, SubtaskStatus subtaskStatus, LocalDate startDate, LocalDate endDate, Task task, Employee employee) {
        this.subtaskName = subtaskName;
        this.description = description;
        this.subtaskStatus = subtaskStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.task = task;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubtaskStatus getSubtaskStatus() {
        return subtaskStatus;
    }

    public void setSubtaskStatus(SubtaskStatus subtaskStatus) {
        this.subtaskStatus = subtaskStatus;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
