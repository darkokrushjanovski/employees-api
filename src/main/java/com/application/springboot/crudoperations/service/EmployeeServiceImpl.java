package com.application.springboot.crudoperations.service;

import com.application.springboot.crudoperations.dao.EmployeeRepository;
import com.application.springboot.crudoperations.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> dbEmployee = employeeRepository.findById(id);

        Employee employee = null;
        if(dbEmployee.isPresent()){
            return dbEmployee.get();
        }else{
            throw new RuntimeException("Employee not found");
        }
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
