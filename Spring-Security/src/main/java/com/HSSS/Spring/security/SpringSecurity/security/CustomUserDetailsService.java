package com.HSSS.Spring.security.SpringSecurity.security;

import com.HSSS.Spring.security.SpringSecurity.entities.Employees;
import com.HSSS.Spring.security.SpringSecurity.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String empName) throws UsernameNotFoundException {
        Employees employees = employeeRepo.findByName(empName);

        if(employees == null){

            throw new UsernameNotFoundException("Not Found");
        }
        return new CustomUser(employees);
    }
}
