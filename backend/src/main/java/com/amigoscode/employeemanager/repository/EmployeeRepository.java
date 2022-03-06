package com.amigoscode.employeemanager.repository;

import com.amigoscode.employeemanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleleEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
