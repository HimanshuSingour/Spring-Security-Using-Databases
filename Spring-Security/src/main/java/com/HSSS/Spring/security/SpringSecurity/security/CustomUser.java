package com.HSSS.Spring.security.SpringSecurity.security;

import com.HSSS.Spring.security.SpringSecurity.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class CustomUser implements UserDetails {

    private Employees employees;

    public CustomUser(Employees employees) {
        super();
        this.employees = employees;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(employees.getEmployeRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return employees.getEmployeePassword();
    }

    @Override
    public String getUsername() {
        return employees.getEmployeeName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
