package com.example.employee_management.service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public Employee updateEmployee(UUID id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id); // Find the existing employee
        existingEmployee.setName(employee.getName());
        existingEmployee.setCode(employee.getCode());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setJoiningDate(employee.getJoiningDate());
        return employeeRepository.save(existingEmployee); // Save the updated employee
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
