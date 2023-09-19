package com.HSSS.Spring.security.SpringSecurity.service;

import com.HSSS.Spring.security.SpringSecurity.entities.Employees;
import com.HSSS.Spring.security.SpringSecurity.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServices{

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employees saveEmployeeData(Employees employees) {
        return employeeRepo.save(employees);
    }

    @Override
    public Employees getEmployeeById(Integer employeeId) {
        Employees emp = employeeRepo.findById(employeeId).orElseThrow();
        return emp;
    }

    @Override
    public List<Employees> getAllEmployee() {
        List<Employees> employees = employeeRepo.findAll();
        return employees;
    }

}
