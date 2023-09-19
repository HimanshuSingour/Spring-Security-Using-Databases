package com.HSSS.Spring.security.SpringSecurity.controller;
import com.HSSS.Spring.security.SpringSecurity.entities.Employees;
import com.HSSS.Spring.security.SpringSecurity.security.CustomUserDetailsService;
import com.HSSS.Spring.security.SpringSecurity.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;



    @PostMapping("/save")
    ResponseEntity<Employees> saveEmployee(@RequestBody Employees employees){
        Employees employees1 = employeeServices.saveEmployeeData(employees);
        return new ResponseEntity<>(employees1 , HttpStatus.CREATED);
    }

    @GetMapping("/get/id/{employeeId}")
    ResponseEntity<Employees> getEmployeeByID(@PathVariable Integer employeeId){
        Employees employees1 = employeeServices.getEmployeeById(employeeId);
        return new ResponseEntity<>(employees1 , HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/all")
    ResponseEntity<List<Employees>> getAllEmployee(){
        List<Employees> employees1 = employeeServices.getAllEmployee();
        return new ResponseEntity<List<Employees>>(employees1 , HttpStatus.ACCEPTED);
    }


}
