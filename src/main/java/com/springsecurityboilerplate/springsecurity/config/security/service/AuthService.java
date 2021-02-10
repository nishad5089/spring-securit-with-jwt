package com.springsecurityboilerplate.springsecurity.config.security.service;

import com.springsecurityboilerplate.model.AuthenticationRequest;
import com.springsecurityboilerplate.springsecurity.data.entity.Users;
import org.springframework.http.ResponseEntity;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 11:40 PM
 * @project springsecurity
 */

public interface AuthService {
    ResponseEntity<?> signIn(AuthenticationRequest authenticationRequest);
    Users createUser(Users user);
}
