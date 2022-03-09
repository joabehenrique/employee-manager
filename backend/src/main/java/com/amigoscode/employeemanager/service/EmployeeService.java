package com.amigoscode.employeemanager.service;

import com.amigoscode.employeemanager.dto.EmployeeDTO;
import com.amigoscode.employeemanager.entity.Employee;
import com.amigoscode.employeemanager.exception.EmployeeNotFoundException;
import com.amigoscode.employeemanager.helper.EmployeeHelper;
import com.amigoscode.employeemanager.repository.EmployeeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeHelper employeeHelper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeHelper employeeHelper) {
        this.employeeRepository = employeeRepository;
        this.employeeHelper = employeeHelper;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employee){
        Employee newEmployee = new Employee();
        employeeHelper.convertDTOtoEntity(newEmployee, employee);
        newEmployee = employeeRepository.save(newEmployee);
        return new EmployeeDTO(newEmployee);
    }

    public Page<EmployeeDTO> findAllEmployees(Pageable page){
        Page<Employee> employees = employeeRepository.findAll(page);
        return employees.map(EmployeeDTO::new);
    }

    public EmployeeDTO findEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id "+id+" not found"));
        return new EmployeeDTO(employee);
    }

    public EmployeeDTO updateEmployee(Employee employee){
        Employee employeeUpdated = employeeRepository.save(employee);
        return new EmployeeDTO(employeeUpdated);
    }

    public void deleteEmployee(Long id){
        try{
            employeeRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EmployeeNotFoundException("Employee by id "+id+" not found");
        }

    }
}
