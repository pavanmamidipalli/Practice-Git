package com.example.TaskManager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    @Autowired
    private LogIn logIn;
    public UserDetailsImpl (LogIn  logIn){
        this.logIn=logIn;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("login"));
    }

    @Override
    public String getPassword() {

        return logIn.getPassword();
    }

    @Override
    public String getUsername() {

        return logIn.getPassword();
    }
}
