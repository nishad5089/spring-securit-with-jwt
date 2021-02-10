package com.springsecurityboilerplate.springsecurity.controller;

import com.springsecurityboilerplate.model.AuthenticationRequest;
import com.springsecurityboilerplate.springsecurity.config.security.service.AuthService;
import com.springsecurityboilerplate.springsecurity.data.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 4:58 PM
 * @project springsecurity
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authService.signIn(authenticationRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user) {
        return ResponseEntity.ok(authService.createUser(user));
    }


//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        return
//    }
}
