package com.HSSS.Spring.security.SpringSecurity.repository;

import com.HSSS.Spring.security.SpringSecurity.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees , Integer> {


    @Query("SELECT a FROM Employees a WHERE a.employeeName = :employeeName")
    Employees findByName(String employeeName);

}
