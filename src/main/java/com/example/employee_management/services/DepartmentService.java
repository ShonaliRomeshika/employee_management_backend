package com.example.employee_management.services;

import com.example.employee_management.model.Department;
import com.example.employee_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        department.setCode("DEPT" + (departmentRepository.count() + 1));
        return departmentRepository.save(department);
    }

    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

    public Department getDepartmentById(UUID id) {
        return departmentRepository.findById(id).orElseThrow();
    }
}
