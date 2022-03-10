package com.amigoscode.employeemanager.dto;

import com.amigoscode.employeemanager.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String address;
    private String skype;
    private String employeeCode;

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
