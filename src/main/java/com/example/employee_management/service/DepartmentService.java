package com.example.employee_management.service;

import com.example.employee_management.model.Department;
import com.example.employee_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import com.example.employee_management.model.Department;
import com.example.employee_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(UUID id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    public Department updateDepartment(UUID id, Department department) {
        Department existingDepartment = getDepartmentById(id); // Find the existing department
        existingDepartment.setName(department.getName());
        existingDepartment.setCode(department.getCode());
        existingDepartment.setLocation(department.getLocation());
        existingDepartment.setBudget(department.getBudget());
        return departmentRepository.save(existingDepartment); // Save the updated department
    }

    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }
}