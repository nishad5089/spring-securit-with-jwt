package com.springsecurityboilerplate.springsecurity.config.security.service;

import com.springsecurityboilerplate.springsecurity.data.entity.Users;
import com.springsecurityboilerplate.springsecurity.data.repository.UserRepo;
import com.springsecurityboilerplate.springsecurity.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 10:00 PM
 * @project springsecurity
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users userEntity = repo.findByEmail(email);
        if (userEntity == null) {
            throw new UserNotFoundException(email);
        }
//        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
        return new User(userEntity.getEmail(), userEntity.getPassword(),
               false,
                true, true,
                true, new ArrayList<>());
    }
}
