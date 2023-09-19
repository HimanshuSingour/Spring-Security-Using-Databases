package com.HSSS.Spring.security.SpringSecurity.service;

import com.HSSS.Spring.security.SpringSecurity.entities.Employees;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface EmployeeServices {

    Employees saveEmployeeData(Employees employees);

    Employees getEmployeeById(Integer employeeId);

    List<Employees> getAllEmployee();

}
