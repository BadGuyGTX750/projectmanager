package com.example.projectmanager.controllers;

import com.example.projectmanager.entities.Employee;
import com.example.projectmanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }
    @PutMapping("/addTask")
    public ResponseEntity<Employee> addTaskToEmployee(@RequestParam("employeeId") Long employeeId,
                                                      @RequestParam("taskId") Long taskId){
        Employee employee = employeeService.addTaskToEmployee(employeeId, taskId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @PutMapping("/removeTask")
    public ResponseEntity<Employee> removeTaskFromEmployee(@RequestParam("employeeId") Long employeeId,
                                                           @RequestParam("taskId") Long taskId){
        Employee employee = employeeService.removeTaskFromEmployee(employeeId, taskId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @PutMapping("/addSubtask")
    public ResponseEntity<Employee> addSubtaskToEmployee(@RequestParam("employeeId") Long employeeId,
                                                         @RequestParam("subtaskId") Long subtaskId){
        Employee employee = employeeService.addSubtaskToEmployee(employeeId, subtaskId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @PutMapping("/removeSubtask")
    public ResponseEntity<Employee> removeSubtaskFromEmployee(@RequestParam("employeeId") Long employeeId,
                                                              @RequestParam("subtaskId") Long subtaskId){
        Employee employee = employeeService.removeSubtaskFromEmployee(employeeId, subtaskId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
