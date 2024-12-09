package com.example.TaskManager.Service.Implementation;

import com.example.TaskManager.model.LogIn;
import com.example.TaskManager.model.UserDetailsImpl;
import com.example.TaskManager.repository.LogInRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
@Service
public class MyUserDetailsService implements UserDetailsService {
    private LogInRepository logInRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       LogIn logIn= logInRepository.findByUserName(username);
        if(ObjectUtils.isEmpty(logIn)){
           return (UserDetails) new UsernameNotFoundException("usernot found");
        }
        return new UserDetailsImpl(logIn);
    }
}
