package com.amigoscode.employeemanager.dto;

import com.amigoscode.employeemanager.entity.Employee;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {
    final private Long id;
    final private String name;
    final private String email;
    final private String jobTitle;
    final private String phone;
    final private String imageUrl;
    final private String address;
    final private String skype;
    final private String employeeCode;

    public EmployeeDTO(Employee newEmployee) {
         this.id = newEmployee.getId();
         this.name = newEmployee.getName();
         this.email = newEmployee.getEmail();
         this.jobTitle = newEmployee.getJobTitle();
         this.phone = newEmployee.getPhone();
         this.imageUrl = newEmployee.getImageUrl();
         this.address = newEmployee.getAddress();
         this.skype = newEmployee.getSkype();
         this.employeeCode = newEmployee.getEmployeeCode();
    }
}
