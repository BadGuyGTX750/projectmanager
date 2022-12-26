package com.example.projectmanager.services;

import com.example.projectmanager.entities.Employee;
import com.example.projectmanager.entities.Subtask;
import com.example.projectmanager.entities.Task;
import com.example.projectmanager.exceptions.EmployeeNotFoundException;
import com.example.projectmanager.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final TaskService taskService;
    private final SubtaskService subtaskService;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, TaskService taskService, SubtaskService subtaskService) {
        this.employeeRepo = employeeRepo;
        this.taskService = taskService;
        this.subtaskService = subtaskService;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee getEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee addTaskToEmployee(Long employeeId, Long taskId){
        Employee employee = getEmployeeById(employeeId);
        Task task = taskService.getTaskById(taskId);
        employee.addToTaskList(task);
        task.setEmployee(employee);
        return employeeRepo.save(employee);
    }
    public Employee removeTaskFromEmployee(Long employeeId, Long taskId){
        Employee employee = getEmployeeById(employeeId);
        Task task = taskService.getTaskById(taskId);
        employee.removeFromTaskList(task);
        task.setEmployee(null);
        return employeeRepo.save(employee);
    }
    public Employee addSubtaskToEmployee(Long employeeId, Long subtaskId){
        Employee employee = getEmployeeById(employeeId);
        Subtask subtask = subtaskService.getSubtaskById(subtaskId);
        employee.addToSubtaskList(subtask);
        subtask.setEmployee(employee);
        return employeeRepo.save(employee);
    }
    public Employee removeSubtaskFromEmployee(Long employeeId, Long subtaskId){
        Employee employee = getEmployeeById(employeeId);
        Subtask subtask = subtaskService.getSubtaskById(subtaskId);
        employee.removeFromSubtaskList(subtask);
        subtask.setEmployee(null);
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
