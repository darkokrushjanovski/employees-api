package com.application.springboot.crudoperations.rest;

import com.application.springboot.crudoperations.entity.Employee;
import com.application.springboot.crudoperations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable("id") int id) {
        Employee employee = employeeService.getById(id);

        if (employee == null) {
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getById(id);
        employeeService.deleteById(employee.getId());
        return employee;
    }
}
