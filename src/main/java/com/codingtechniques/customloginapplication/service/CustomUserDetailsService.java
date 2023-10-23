package com.codingtechniques.customloginapplication.service;

import com.codingtechniques.customloginapplication.model.User;
import com.codingtechniques.customloginapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username or passowrd not found");
        }
        return new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                authorities(),
                user.getFullname());
    }

    public Collection<? extends GrantedAuthority> authorities (){
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
