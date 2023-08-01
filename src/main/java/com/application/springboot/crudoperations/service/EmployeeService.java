package com.application.springboot.crudoperations.service;

import com.application.springboot.crudoperations.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee getById(int id);
    Employee save(Employee employee);

    void deleteById(int id);
}
