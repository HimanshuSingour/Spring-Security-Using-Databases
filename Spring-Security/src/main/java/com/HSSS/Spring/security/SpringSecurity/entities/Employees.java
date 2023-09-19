package com.HSSS.Spring.security.SpringSecurity.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_TABLE")
@Component
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private Integer employeeId;

    @Column(name = "EMP_NAME")
    private String employeeName;

    @Column(name = "EMP_ROLE")
    private String employeRole;

    @Column(name = "EMP_PASSWORD")
    private String employeePassword;

}
