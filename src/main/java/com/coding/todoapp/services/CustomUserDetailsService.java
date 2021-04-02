package com.coding.todoapp.services;

import com.coding.todoapp.model.CustomUserDetail;
import com.coding.todoapp.model.User;
import com.coding.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser=userRepository.findUserByEmail(name);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("nhi mila user"));
        return optionalUser.map(CustomUserDetail::new).get();
    }
}
