package com.example.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_management.model.Department;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {}
