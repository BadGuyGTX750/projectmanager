package com.example.projectmanager.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String projectName;
    private String description;
    private ProjectStatus projectStatus;
    private LocalDate creationDate = LocalDate.now();
    private LocalDate finishDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Sprint> sprintList = new ArrayList<>();

    public Project() {
    }
    public Project(String projectName, String description, ProjectStatus projectStatus, LocalDate creationDate, LocalDate finishDate, List<Sprint> sprintList) {
        this.projectName = projectName;
        this.description = description;
        this.projectStatus = projectStatus;
        this.creationDate = creationDate;
        this.finishDate = finishDate;
        this.sprintList = sprintList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public List<Sprint> getSprintList() {
        return sprintList;
    }

    public void setSprintList(List<Sprint> sprintList) {
        this.sprintList = sprintList;
    }

    public void addToSprintList(Sprint sprint){
        sprintList.add(sprint);
    }
    public void removeFromSprintList(Sprint sprint){
        sprintList.remove(sprint);
    }
}
