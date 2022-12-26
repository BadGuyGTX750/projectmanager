package com.example.projectmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sprint")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String sprintName;
    private String description;
    private SprintStatus sprintStatus;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprint")
    private List<Task> taskList = new ArrayList<>();
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "project_id")
    private Project project;

    public Sprint() {
    }
    public Sprint(String sprintName, String description, SprintStatus sprintStatus, LocalDate startDate, LocalDate endDate, List<Task> taskList, Project project) {
        this.sprintName = sprintName;
        this.description = description;
        this.sprintStatus = sprintStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskList = taskList;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SprintStatus getSprintStatus() {
        return sprintStatus;
    }

    public void setSprintStatus(SprintStatus sprintStatus) {
        this.sprintStatus = sprintStatus;
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

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void addToTaskList(Task task){
        taskList.add(task);
    }

    public void removeFromTaskList(Task task){
        taskList.remove(task);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
