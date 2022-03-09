package com.amigoscode.employeemanager.helper;

import com.amigoscode.employeemanager.dto.EmployeeDTO;
import com.amigoscode.employeemanager.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmployeeHelper {
    public void convertDTOtoEntity(Employee entity, EmployeeDTO dto){
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setJobTitle(dto.getJobTitle());
        entity.setPhone(dto.getPhone());
        entity.setImageUrl(dto.getImageUrl());
        entity.setAddress(dto.getAddress());
        entity.setSkype(dto.getSkype());
        entity.setEmployeeCode(UUID.randomUUID().toString());
    }
}
