package com.springsecurityboilerplate.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 5:08 PM
 * @project springsecurity
 */
@RestController
@RequestMapping("")
public class HomeController {
    @GetMapping("/home")
    public ResponseEntity<?> authenticateUser() {
        return ResponseEntity.ok("Hello World!");
    }
}
