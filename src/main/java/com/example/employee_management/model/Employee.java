package com.example.employee_management.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employees") // Specify the table name
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, unique = true)
    private String email;

    private Double salary;

    private String position;

    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Default constructor
    public Employee() {}

    // Constructor with parameters
    public Employee(String name, String code, String email, Double salary, String position, Date joiningDate, Department department) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.salary = salary;
        this.position = position;
        this.joiningDate = joiningDate;
        this.department = department;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
