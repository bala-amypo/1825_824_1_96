package com.example.demo.security;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

@Service
public class CustonUserDetailsService implements UserDetailsService{
    @Autowired
    private UserAccountRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserAccount user=repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return User.withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
    }
}



